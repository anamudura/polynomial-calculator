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
        String mon = "";
        switch (exponent) {
            case 0:
                mon = String.valueOf(coeficient);
                return mon;

            case 1:
                switch (coeficient) {
                    case 0:
                        mon = "0";
                        return mon;
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
                    case 0:
                        mon = "0";
                        return mon;
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
        int nc, ne;
        if ((m1.getGrad() == 0 && m2.getGrad() == 1) || (m1.getGrad() == 1 && m2.getGrad() == 0))
            ne = 1;
        else
            ne = m1.getGrad() + m2.getGrad();
        if ((m1.getCoeficient() == 0 && m2.getCoeficient() == 1) || (m1.getCoeficient() == 1 && m2.getCoeficient() == 0))
            nc = 1;
        else
            nc = m1.getCoeficient() * m2.getCoeficient();
        Monom m3 = new Monom(nc, ne);
        return m3;
    }
}
