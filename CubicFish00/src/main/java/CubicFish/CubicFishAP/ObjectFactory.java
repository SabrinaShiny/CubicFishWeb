package classes;

public abstract class ObjectFactory {
	protected String url ="jdbc:mysql://localhost:3306/cubicfish";
	protected String user ="root";
	protected String password ="";

	//using an abstract method so we can later use builder for all constructors
	public abstract Resident[] builder();
}