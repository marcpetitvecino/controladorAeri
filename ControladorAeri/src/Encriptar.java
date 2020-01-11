import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class Encriptar {

    public Avio encriptar (Avio avio) {

        String encriptat;
        String arxiu = "hashes/"+avio.getMatricula()+".hash";

        encriptat = Base64.getEncoder().encodeToString(avio.getMatricula().getBytes(StandardCharsets.UTF_8));

        try (FileWriter fw = new FileWriter(arxiu, true); BufferedWriter bw = new BufferedWriter(fw); PrintWriter out = new PrintWriter(bw)) {

            out.println(encriptat);

        } catch (IOException e) {

            e.printStackTrace();

        }

        avio.setMarca(Base64.getEncoder().encodeToString(avio.getMarca().getBytes(StandardCharsets.UTF_8)));
        avio.setModel(Base64.getEncoder().encodeToString(avio.getModel().getBytes(StandardCharsets.UTF_8)));
        avio.setXifrat(true);

        return avio;


    }

    public Avio desencriptar (Avio avio) {

        String comparacio;
        String hash = "";
        String arxiu = "hashes/" + avio.getMatricula() + ".hash";

        try {
            hash = new String(Files.readAllBytes(Paths.get(arxiu)));
            hash = hash.substring(0, hash.length() - 2);
        } catch (Exception e) {

            e.printStackTrace();

        }

        comparacio = Base64.getEncoder().encodeToString(avio.getMatricula().getBytes(StandardCharsets.UTF_8));

        if (hash.equals(comparacio)) {
            byte[] decodeMarca = Base64.getDecoder().decode(avio.getMarca().getBytes());
            byte[] decodeModel = Base64.getDecoder().decode(avio.getModel().getBytes());

            avio.setMarca(new String(decodeMarca, StandardCharsets.UTF_8));
            avio.setModel(new String(decodeModel, StandardCharsets.UTF_8));

            avio.setXifrat(false);

            File file = new File(arxiu);

            file.delete();

        } else {

            System.out.println("Verificació fallada");
        }

        return avio;

    }

}
