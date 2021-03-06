package main;
import java.lang.Math;

public class Integral {
	private static final int NEXP = 100000;
	private static double f(double x) {
		return x*x;
	}
	private static double h(double c, double x) {
		return c*x*x*x;
	}
	private static double g(double x) {
		return Math.exp(x)/(Math.pow(x, 2)+1);
	}
	public static double integralx2(double a, double b, double c) {
		int cont=0;
		for(int i=0;i<NEXP;i++) {
			double x = Math.random()*(b-a)+a;
			double y = Math.random()*c;
			if(y < f(x)) {
				cont++;
			}
		}
		return (double) cont/NEXP*(b-a)*c;
	}
	public static double integralfx(double a, double b, Funcao fx){
		int cont=0;
		double c = fx.eval();
		for(int i=0;i<NEXP;i++){
		    double x = Math.random()*(b-a)+a;
		    double y = Math.random()*c;
		    fx.setVariavel(x);
		    if(y < fx.eval()){
		        cont++;
            }
        }
        return (double) cont/NEXP*(b-a)*c;
    }
	public static double integralcx3(double a, double b, double c) {
		int cont=0;
		for(int i=0;i<NEXP;i++) {
			double x = Math.random()*(b-a)+a;
			double y = Math.random()*c;
			if(y < h(c, x)) {
				cont++;
			}
		}
		return (double) cont/NEXP*(b-a)*c;
	}
	public static double integralexpx(double a, double b, double c) {
		int cont=0;
		for(int i=0;i<NEXP;i++) {
			double x = Math.random()*2+1;
			double y = Math.random()*c;
			if(y < g(x)) {
				cont++;
			}
		}
		return (double) cont/NEXP*(b-a)*c;
	}
}
