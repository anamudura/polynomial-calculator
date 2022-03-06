import java.util.LinkedList;

public class Polinom {
    private LinkedList<Monom> polinom;

    public LinkedList<Monom> getPolinom() {
        return polinom;
    }

    public Polinom() {
        polinom = new LinkedList<Monom>();
    }

    public void AddTerm(int coefficient, int exponent) {
        Monom t1 = new Monom(coefficient, exponent);
        if (exponent > polinom.getFirst().getGrad()) {
            polinom.addFirst(t1);
        } else {
            for (int j = 0; j < polinom.size(); j++) {
                if (polinom.get(j).getGrad() == exponent) {
                    Monom t2 = new Monom(coefficient + polinom.get(j).getCoeficient(), exponent);
                    polinom.set(j, t2);
                    break;
                } else if (polinom.getLast() == polinom.get(j)) {
                    polinom.addLast(t1);
                    break;
                } else if (polinom.get(j).getGrad() > t1.getGrad() && t1.getGrad() > polinom.get(j + 1).getGrad()) {
                    polinom.add(j + 1, t1);
                    break;
                }
            }
        }
    }

    public void SubTerm(int coefficient, int exponent) {
        Monom t1 = new Monom(-coefficient, exponent);
        if (exponent > polinom.getFirst().getGrad()) {
            polinom.addFirst(t1);
        } else {
            for (int j = 0; j < polinom.size(); j++) {
                if (polinom.get(j).getGrad() == exponent) {
                    Monom t2 = new Monom(polinom.get(j).getCoeficient() - coefficient, exponent);
                    polinom.set(j, t2);
                    break;
                } else if (polinom.getLast() == polinom.get(j)) {
                    polinom.addLast(t1);
                    break;
                } else if (polinom.get(j).getGrad() > t1.getGrad() && t1.getGrad() > polinom.get(j + 1).getGrad()) {
                    polinom.add(j + 1, t1);
                    break;
                }
            }
        }
    }

    public String toString() {
        String poli = "";
        for (Monom temp : polinom) {
            if (temp.getGrad() == 0) {
                if (temp.getCoeficient() > 0)
                    poli += "+" + temp.getCoeficient();
                else if (temp.getCoeficient() < 0)
                    poli += temp.getCoeficient();
            } else if (temp != polinom.getFirst() && temp.getGrad() > 0) {
                poli += "+" + temp.toString();
            } else {
                poli += temp.toString();
            }
        }
        if (poli.charAt(0) == '+') {
            String newPolynomial = poli.substring(1, poli.length());
            return newPolynomial;
        } else if (poli.charAt(0) == '-') {
            String newPolynomial = poli.substring(1, poli.length());
            return newPolynomial;
        }

        return poli;
    }

    public void add(Polinom y) {
        for (Monom temp : y.polinom) {
            AddTerm(temp.getCoeficient(), temp.getGrad());
        }
    }

    public void subtract(Polinom y) {
        for (Monom temp : y.polinom) {
            SubTerm(temp.getCoeficient(), temp.getGrad());
        }
    }

    public void multiply(Polinom y) {
        LinkedList<Monom> p = new LinkedList<Monom>();
        for (Monom temp : polinom) {
            for (Monom newTemp : y.polinom) {
                Monom m = temp.multiply(temp, newTemp);
                if (p.size() == 0) {
                    p.add(m);
                } else if (m.getGrad() > p.getFirst().getGrad()) {
                    p.addFirst(m);
                } else {
                    for (int j = 0; j < p.size(); j++) {
                        if (p.get(j).getGrad() == m.getGrad()) {
                            Monom m2 = new Monom(m.getCoeficient() + p.get(j).getCoeficient(), m.getGrad());
                            p.set(j, m2);
                            break;
                        } else if (p.getLast() == p.get(j)) {
                            p.add(m);
                            break;
                        } else if (p.get(j).getGrad() > m.getGrad() && m.getGrad() > p.get(j + 1).getGrad()) {
                            p.add(j + 1, m);
                            break;
                        }
                    }
                }
            }
        }
        polinom = p;
    }

    public void derivation(Polinom y) {
        for (int j = 0; j < polinom.size(); j++)
            if (polinom.get(j).getGrad() == 1) {
                Monom t1 = new Monom(polinom.get(j).getCoeficient() * polinom.get(j).getGrad(), 0);
                polinom.set(j, t1);
            } else if (polinom.get(j).getGrad() == 0) {
                Monom t1 = new Monom(0, 0);
                polinom.set(j, t1);
            } else {
                Monom t1 = new Monom(polinom.get(j).getCoeficient() * polinom.get(j).getGrad(), polinom.get(j).getGrad() - 1);
                polinom.set(j, t1);
            }

    }
    public void integration(Polinom y) {
        for (int j = 0; j < polinom.size(); j++)
            if(polinom.get(j).getGrad()==0){
            Monom t1 = new Monom(polinom.get(j).getCoeficient(), 1);
            polinom.set(j, t1);
        }
        else
            {
                double c = Double.valueOf(polinom.get(j).getCoeficient()/(polinom.get(j).getGrad()+1));
                Monom t1 = new Monom(polinom.get(j).getCoeficient()/(polinom.get(j).getGrad()+1),polinom.get(j).getGrad()+1);
                polinom.set(j,t1);
            }

    }

    public void getInput(String input) {
        String[] splitString = input.split("(?=[+-])");
        createNode(splitString);
    }

    public void createNode(String[] splitString) {
        for (int i = 0; i < splitString.length; i++) {
            String[] split = splitString[i].split("[x^]");
            if (split.length == 3) {
                String node = split[0];
                switch (node) {
                    case "-":
                        Monom m1 = new Monom(-1, Integer.parseInt(split[2]));
                        polinom.add(m1);
                        break;
                    case "+":
                        Monom m2 = new Monom(1, Integer.parseInt(split[2]));
                        polinom.add(m2);
                        break;
                    case "":
                        Monom m3 = new Monom(1, Integer.parseInt(split[2]));
                        polinom.add(m3);
                        break;
                    default:
                        Monom m4 = new Monom(Integer.parseInt(split[0]), Integer.parseInt(split[2]));
                        polinom.add(m4);
                        break;
                }
            } else if (split.length == 1) {
                if (splitString[i].contains("x") == false) {
                    Monom m1 = new Monom(Integer.parseInt(split[0]), 0);
                    polinom.add(m1);
                } else if (splitString[i].contains("x") == true) {
                    String node = split[0];
                    switch (node) {
                        case "-":
                            Monom t1 = new Monom(-1, 1);
                            polinom.add(t1);
                            break;
                        case "+":
                            Monom m2 = new Monom(1, 1);
                            polinom.add(m2);
                            break;
                        default:
                            Monom m3 = new Monom(Integer.parseInt(split[0]), 1);
                            polinom.add(m3);
                            break;
                    }
                }
            } else if (split.length == 0) {
                Monom m1 = new Monom(1, 1);
                polinom.add(m1);
            }
        }
    }

}
