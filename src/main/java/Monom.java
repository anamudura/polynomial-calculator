public class Monom {
    private int exponent;
    private int coeficient;

    public Monom(int coef, int grad) {
        this.exponent = grad;
        this.coeficient = coef;
    }

    public int getGrad() {
        return exponent;
    }

    public void setGrad(int grad) {
        this.exponent = grad;
    }

    public int getCoeficient() {
        return coeficient;
    }

    public void setCoeficient(int coeficient) {
        this.coeficient = coeficient;
    }

    public String toString() {
        String mon;
        switch (exponent) {
            case 0:
                mon = String.valueOf(coeficient);
                return mon;

            case 1:
                switch (coeficient) {
                    case 1:
                        mon = "x";
                        return mon;
                    case -1:
                        mon = "-x";
                        return mon;
                    default:
                        mon = String.valueOf(coeficient) + "x";
                        return mon;
                }
            default:
                switch (coeficient) {
                    case 1:
                        mon = "x" + "^" + String.valueOf(exponent);
                        return mon;
                    case -1:
                        mon = "-x" + "^" + String.valueOf(exponent);
                        return mon;
                    default:
                        mon = String.valueOf(coeficient) + "x" + "^" + String.valueOf(exponent);
                        return mon;
                }
        }
    }
    public Monom multiply(Monom m1, Monom m2) {
        int nc = m1.getGrad() * m2.getGrad();
        int ne = m1.getCoeficient() + m2.getCoeficient();
        Monom m3 = new Monom(ne, nc);
        return m3;
    }
}
