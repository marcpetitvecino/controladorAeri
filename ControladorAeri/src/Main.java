import java.util.Scanner;

public class Main
{

    static Scanner lector = new Scanner(System.in);
    static Avio[]espaiAeri = new Avio[10];

    public static void main(String[] args) {

        boolean sortir = false;
        int decisio = 0;
        boolean introduit = false;
        Coordenada pistaAterratge = new Coordenada();
        String matricula;

        while (!sortir) {

            menuPrincipal();
            decisio = lector.nextInt();

            switch (decisio) {

                case 1:

                    if (checkPista()) {

                        Avio nouAvio = new Avio().generarAvio();

                        for (int i = 0; i < espaiAeri.length; i++) {

                            if (espaiAeri[i] == null && !introduit) {

                                espaiAeri[i] = nouAvio;
                                nouAvio.setCoordenades(pistaAterratge.CoordenadaAterratge());
                                introduit = true;

                            } else if (!introduit) {

                                System.out.println("L'espai aeri està ple");
                                introduit = false;
                            }

                        }

                        introduit = false;

                    } else if (!checkPista()) {

                        System.out.println("Segur que vols crear l'avió? provocarà un accident: ");
                        System.out.println("1- Si");
                        System.out.println("2- No");

                        decisio = lector.nextInt();

                        switch (decisio) {

                            case 1:

                                introduit = false;

                                System.out.println("Ets un monstre");

                                Avio nouAvio = new Avio().generarAvio();

                                for (int i = 0; i < espaiAeri.length; i++) {

                                    if (espaiAeri[i] == null && !introduit) {

                                        nouAvio.setCoordenades(pistaAterratge.CoordenadaAterratge());
                                        introduit = true;

                                    } else if (!introduit) {

                                        System.out.println("L'espai aeri està ple");
                                        introduit = false;
                                    }

                                }

                                System.out.println("BOOOOOOOOOOOOOM");
                                System.out.println("L'avio ha explotat");

                                break;

                            case 2:

                                System.out.println("Ben fet");

                                break;

                            default:

                                System.out.println("Introdueix una opció vàlida");

                        }

                    }

                    break;

                case 2:

                    System.out.println("Introdueix la matricula del avió: ");
                    matricula = lector.next();

                    for (int i = 0; i < espaiAeri.length; i++) {

                        Avio check = espaiAeri[i];

                        if (check != null) {
                            if (matricula.equals(check.getMatricula())) {

                                boolean sortirMenuAvio = false;

                                while (!sortirMenuAvio) {

                                    menuAvio();
                                    String decisioMenuAvio = lector.next();

                                    switch (decisioMenuAvio.toLowerCase()) {

                                        case "a":

                                            check.getMotor().engegar();
                                            break;

                                        case "b":

                                            check.getMotor().apagar();
                                            break;

                                        case "c":

                                            System.out.println("A quina velocitat vols accelerar?");
                                            double velocitatAccel = lector.nextDouble();

                                            if (velocitatAccel > check.getVelocitat()) {

                                                check.setVelocitat(velocitatAccel);

                                            } else {

                                                System.out.println("No pots anar més lent si acceleres");

                                            }
                                            break;

                                        case "d":

                                            System.out.println("A quina velocitat vols frenar?");

                                            double velocitatFrenar = lector.nextDouble();

                                            if (velocitatFrenar < check.getVelocitat()) {

                                                check.setVelocitat(velocitatFrenar);

                                            } else {

                                                System.out.println("No pots anar més ràpid si vols frenar");

                                            }

                                            break;

                                        case "e":

                                            System.out.println("A quina alçada vols pujar?");

                                            double alcadapujar = lector.nextInt();

                                            if (alcadapujar > check.getAlcada()) {

                                                check.setAlcada(alcadapujar);

                                            } else if (alcadapujar > 50000) {

                                                System.out.println("No pots anar a la estratosfera");

                                            } else {

                                                System.out.println("No pots anar a una alçada inferior si pujes");

                                            }

                                            break;

                                        case "f":

                                            System.out.println("A quina alçada vols pujar?");

                                            double alcadabaixar = lector.nextInt();

                                            if (alcadabaixar < check.getAlcada()) {

                                                check.setAlcada(alcadabaixar);

                                            } else if (alcadabaixar < 0) {

                                                System.out.println("No pots baixar més abaix que 0");

                                            } else {

                                                System.out.println("No pots anar a una alçada superior si baixes");

                                            }

                                            break;

                                        case "g":

                                            if (check.isTrenAterratge()) {

                                                System.out.println("El tren d'aterratge està baixat, el vols pujar? (S/N)");
                                                String decisioTren = lector.next();

                                                if (decisioTren.equalsIgnoreCase("s")) {

                                                    check.setTrenAterratge(false);

                                                }


                                            } else {

                                                System.out.println("El tren d'aterratge esta pujat, el vols baixar? (S/N)");
                                                String decisioTren = lector.next();

                                                if (decisioTren.equalsIgnoreCase("s")) {

                                                    check.setTrenAterratge(true);

                                                }

                                            }

                                            break;

                                        case "h":

                                            System.out.println("Estableix el rumb: ");
                                            int rumb = lector.nextInt();

                                            if (rumb > 0 && rumb < 360) {

                                                check.setRumb(rumb);

                                            } else {

                                                System.out.println("El rumb ha d'estar entre 0 i 360");

                                            }

                                            break;

                                        case "i":

                                            System.out.println("Posiciona la X i la Y del avió");
                                            System.out.println("X:");
                                            double x = lector.nextDouble();
                                            System.out.println("Y:");
                                            double y = lector.nextDouble();

                                            check.getCoordenades().setX(x);
                                            check.getCoordenades().setY(y);

                                            break;

                                        case "j":

                                            break;

                                        case "k":
                                            sortirMenuAvio = true;
                                            break;

                                        default:
                                            System.out.println("Introdueix una opció vàlida: ");

                                    }

                                }

                            } else {

                                System.out.println("No s'ha trobat un avió amb aquesta matricula");

                            }

                        }

                    }

                    break;

                case 3:

                    for (int i = 0; i < espaiAeri.length; i++) {

                        Avio info = espaiAeri[i];

                        if (info != null) {

                            System.out.println("Aeronau "+ (i+1));
                            System.out.println("Marca: " + info.getMarca());
                            System.out.println("Model: " + info.getModel());
                            if (info.isXifrat()) {
                                System.out.println("Matricula: ENCRIPTAT");
                            } else {
                                System.out.println("Matrícula: " + info.getMatricula());
                            }
                            System.out.println("X: " + info.getCoordenades().getX());
                            System.out.println("Y: " + info.getCoordenades().getY());
                            System.out.println("Alçada: " + info.getAlcada());
                            System.out.println("Velocitat: " + info.getVelocitat());
                            System.out.println("Tren aterratge: " + info.isTrenAterratge());
                            System.out.println("Motor: " + info.getMotor().status());
                            // System.out.println("Misils: " + info.getMissils().length);
                            System.out.println("Origen: " + info.getOrigen());
                            System.out.println("Desti: " + info.getDesti());
                        }
                        System.out.println(" ");



                    }

                    break;

                case 4:

                    System.out.println("Introdueix la matricula del avió: ");
                    matricula = lector.next();

                    for (int i = 0; i < espaiAeri.length; i++) {

                        Avio check = espaiAeri[i];
                        if (check != null) {
                         
                        if (matricula.equals(check.getMatricula()) && check instanceof AvioMilitar) {

                            Encriptar encriptar = new Encriptar();

                            encriptar.encriptar(check);

                        } else {

                            System.out.println("L' avio no s'ha trobat o no és un avio militar");

                        }
                            
                        }

                    }

                    break;

                case 5:

                    System.out.println("Introdueix la matricula del avió: ");
                    matricula = lector.next();

                    for (int i = 0; i < espaiAeri.length; i++) {

                        Avio check = espaiAeri[i];
                        if (check != null) {
                        
                        if (matricula.equals(check.getMatricula()) && check instanceof AvioMilitar) {

                            Encriptar encriptar = new Encriptar();

                            encriptar.desencriptar(check);

                        } else {

                            System.out.println("L' avio no s'ha trobat o no és un avio militar");

                        }
                        
                        }

                    }

                    break;

                case 6:

                    sortir = true;

                    break;

                default:

                    System.out.println("Introdueix una opció vàlida");

            }

        }


    }

    private static void menuPrincipal() {

        System.out.println("");
        System.out.println("Escolleix que vols fer: ");

        System.out.println("1- Afegir un avió a l’espai aeri");
        System.out.println("2- Gestionar un avió de l’espai Aeri.");
        System.out.println("3- Mostrar L’espai Aeri actual.");
        System.out.println("4-  Xifrar els avions de combat");
        System.out.println("5- Desxifrar els avions de combat");
        System.out.println("6- Sortir");

    }

    private static void menuAvio() {

        System.out.println("");
        System.out.println("Escolleix que vols fer: ");

        System.out.println("a- Encendre Motor");
        System.out.println("b- Apagar Motor");
        System.out.println("c- Accelerar");
        System.out.println("d- Frenar");
        System.out.println("e- Agafar alçada");
        System.out.println("f- Baixar alçada");
        System.out.println("g- Pujar/Baixar tren aterratge");
        System.out.println("h- Establir rumb");
        System.out.println("i- Posicionar X/Y");
        System.out.println("j- Disparar Avió comercial sospitós");
        System.out.println("k- Finalitzar operativa avió seleccionat");

    }

    private static boolean checkPista() {

        for (int i = 0; i < espaiAeri.length; i++) {

            Avio check = espaiAeri[i];

            if (check != null) {

                if (check.getCoordenades().getX() == 100 && check.getCoordenades().getY() == 100) {

                    return false;

                }

            }

        }

        return true;

    }

}
