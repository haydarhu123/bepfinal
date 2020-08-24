package nl.hu.bep.aquarium.persistence;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobContainerClientBuilder;
import nl.hu.bep.aquarium.domeinmodel.AquariumManager;

import java.io.*;

public class PersisManager {
    private final static String ENDPOINT = "https://bepfinalassopslagh.blob.core.windows.net/";
    private final static String SASTOKEN = "?sv=2019-10-10&ss=bfqt&srt=sco&sp=rwdlacupx&se=2020-06-03T00:48:46Z&st=2020-06-02T16:48:46Z&spr=https&sig=Kr22zi4sQCwJPoshnQCLOE3xrwsLkVj00UCJlCW9McI%3D";
    private final static String CONTAINER = "bepfinalassopslagh";

    private static BlobContainerClient blobContainer = new BlobContainerClientBuilder().endpoint(ENDPOINT).sasToken(SASTOKEN).containerName(CONTAINER).buildClient();

    public static void loadFromAzure() throws IOException, ClassNotFoundException {
        if(blobContainer.exists()){
            BlobClient blobcl = blobContainer.getBlobClient("country_blob");

            if(blobcl.exists()){
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                blobcl.download(baos);

                byte[] bytez = baos.toByteArray();
                ByteArrayInputStream bais = new ByteArrayInputStream(bytez);
                ObjectInputStream ois = new ObjectInputStream(bais);

                AquariumManager aquariumManager = (AquariumManager) ois.readObject();
                AquariumManager.setAquariumManager(aquariumManager);

                System.out.println("Het laden van azure werkt!");

            }else{
                System.out.println("Het ophalen van azure is mislukt, probeer opnieuw");
            }
        }

    }
    public static void saveToAzure() throws IOException {
        if(!blobContainer.exists()){
            blobContainer.create();
        }
        BlobClient blobc = blobContainer.getBlobClient("country_blob");

        AquariumManager aquaman = AquariumManager.getAquariumManager();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);

        oos.writeObject(aquaman);

        byte[] bytez = baos.toByteArray();
        ByteArrayInputStream bais = new ByteArrayInputStream(bytez);
        blobc.upload(bais, bytez.length, true);
        System.out.println("het opslaan is voltooid");
    }
}
