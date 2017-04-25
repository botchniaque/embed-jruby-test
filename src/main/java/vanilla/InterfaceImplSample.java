package vanilla;

import java.util.List;
import org.jruby.embed.PathType;
import org.jruby.embed.ScriptingContainer;

public class InterfaceImplSample {
    private final String filename1 = "ruby/calculation.rb";
    private final String filename2 = "ruby/fluid_force.rb";

    private InterfaceImplSample() {
        System.out.println("[" + getClass().getName() + "]");
        ScriptingContainer container = new ScriptingContainer();

        // implemented by a Ruby class
        Object receiver = container.runScriptlet(PathType.CLASSPATH, filename1);
        Calculable c = container.getInstance(receiver, Calculable.class);
        List<Long> xyz = c.dimension(10L);
        System.out.format("Dimensions are %d x %d x %d.\n", xyz.get(0), xyz.get(1), xyz.get(2));
        double adjacent = 3.0;
        double opposite = 4.0;
        Double hypotenuse = c.hypotenuse(adjacent, opposite);
        System.out.format("Adjacent, opposite, and hypotenuse are %.2f, %.2f, %.2f.\n",
                adjacent, opposite, hypotenuse);

        // implemented by a top level method
        container.getVarMap().clear();
        container.put("@w", 62.4); // weight-densities of water in pounds per cubic foot
        receiver = container.runScriptlet(PathType.CLASSPATH, filename2);
        FluidForce f = container.getInstance(receiver, FluidForce.class);
        double a = 2.0;
        double b = 3.0;
        double depth = 6.0;
        Double force = f.getFluidForce(a, b, depth);
        System.out.format("Water force to %.2f ft x %.2f ft ellipse in depth of %.2f ft is %.5f lb.\n",
                a, b, depth, force);

    }

    public static void main(String[] args) {
        new InterfaceImplSample();
    }
}
