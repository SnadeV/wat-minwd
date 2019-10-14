import com.joptimizer.functions.ConvexMultivariateRealFunction;
import com.joptimizer.functions.LinearMultivariateRealFunction;
import com.joptimizer.optimizers.JOptimizer;
import com.joptimizer.optimizers.OptimizationRequest;

public class JoptimizerExample {

  /*
   * This example is solving basic linear optimization task
   *
   * Example:
   * Minimize: 10x + 7y
   * While:
   * x + 2y >= 8
   * 4x + 6y >= 12
   * All factors are greater or equal zero.
   *
   */
  public static void main(String[] args) throws Exception {

    // Initialize objective function
    LinearMultivariateRealFunction objectiveFunction =
        new LinearMultivariateRealFunction(new double[] {10.0, 7.0}, 0); //minimize 10x+7y

    // Initialize inequalities constraints
    ConvexMultivariateRealFunction[] constraints = new ConvexMultivariateRealFunction[4];
    // x >= 0
    constraints[0] = new LinearMultivariateRealFunction(new double[] {-1.0, 0.00}, 0.0);  // -x + 0 <= 0
    // y >= 0
    constraints[1] = new LinearMultivariateRealFunction(new double[] {0.0, -1.00}, 0.0);  // -y + 0 <= 0
    // x + 2y >= 8
    constraints[2] = new LinearMultivariateRealFunction(new double[] {-1.0, -2.00}, 8.0); // -1x - 2y + 8 <= 0
    // 4x + 6y >= 12
    constraints[3] = new LinearMultivariateRealFunction(new double[] {-4.0, -6.00}, 12.0);// -4x -6y + 12 <= 0

    // Initialize optimization request
    OptimizationRequest request = new OptimizationRequest();
    request.setF0(objectiveFunction);
    request.setFi(constraints);

    // Set tolerance
    request.setToleranceFeas(1.E-9);
    request.setTolerance(1.E-9);

    // Initialize JOptimizer and get optimization result
    JOptimizer optimizer = new JOptimizer();
    optimizer.setOptimizationRequest(request);
    optimizer.optimize();

    double[] solution = optimizer.getOptimizationResponse().getSolution();

    // Print result
    System.out.println("Length: " + solution.length);
    for (int i = 0; i < solution.length / 2; i++) {
      System.out.println("X" + (i + 1) + ": " + Math.round(solution[i]) + "\tY" + (i + 1) + ": " + Math.round(solution[i + 1]));
    }
  }
}
