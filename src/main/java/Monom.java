public class Monom {
    private int exponent;
    private int coeficient;

    public Monom(int grad, int coef) {
        this.exponent = grad;
        this.coeficient = coef;
    }

    public int getGrad() {
        return exponent;
    }

    public void setGrad(int grad) {
        this.exponent = grad;
    }

    public double getCoeficient() {
        return coeficient;
    }

    public void setCoeficient(int coeficient) {
        this.coeficient = coeficient;
    }

    public String toString() {
        String term;
        switch (exponent) {
            case 0:
                term = String.valueOf(coeficient);
                return term;

            case 1:
                switch (coeficient) {
                    case 1:
                        term = "x";
                        return term;
                    case -1:
                        term = "-x";
                        return term;
                    default:
                        term = String.valueOf(coeficient) + "x";
                        return term;
                }
            default:
                switch (coeficient) {
                    case 1:
                        term = "x" + "^" + String.valueOf(exponent);
                        return term;
                    case -1:
                        term = "-x" + "^" + String.valueOf(exponent);
                        return term;
                    default:
                        term = String.valueOf(coeficient) + "x" + "^" + String.valueOf(exponent);
                        return term;
                }
        }
    }
}
