class Calculation
  include Java::vanilla.Calculable
  def dimension(base)
    x = base + 1
    y = base + 2
    z = base - 1
    return x, y, z
  end
  def hypotenuse(adjacent, opposite)
    Math.hypot(adjacent, opposite)
  end
end
Calculation.new
