package nl.hu.bep.aquarium.listeners;

import nl.hu.bep.aquarium.domeinmodel.*;
import nl.hu.bep.aquarium.persistence.PersisManager;
import reactor.core.scheduler.Schedulers;
import reactor.netty.http.HttpResources;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;


public class MijnContextListener implements ServletContextListener {
    @Override

    public void contextInitialized(ServletContextEvent sce){
        try {
            PersisManager.loadFromAzure();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        AquariumManager aquaria = AquariumManager.getAquariumManager();
//        Eigenaar owner = aquaria.getAlleEigenaren().stream().filter(e -> e.getEmail().equals("haydar@gmail.com")).findFirst().orElse(null);
//
//        aquaria.getAlleEigenaren().stream().filter(e -> e.getEmail().equals("haydar@gmail.com")).findFirst().orElse(null).setRole("beheerder");
//
//
//        Bewoner vis1 = new Bewoner("inktvis", "blauw", 12, true);
//        ArrayList<Bewoner> bewoners = new ArrayList<Bewoner>();
//        bewoners.add(vis1);
//
//        Bewoner vis2 = new Bewoner("zeester", "grijs", 500, true);
//        ArrayList<Bewoner> bewoners2 = new ArrayList<Bewoner>();
//        bewoners.add(vis2);
//
//        Bewoner vis3 = new Bewoner("orka", "groen", 1, true);
//        bewoners2.add(vis3);
//
//        Bewoner vis4 = new Bewoner("zeewier", "groen", 2, true);
//        bewoners2.add(vis4);
//
//        Toebehoren toebehore = new Toebehoren("QZXE", "gugyug34545");
//        ArrayList<Toebehoren> toebehorens = new ArrayList<Toebehoren>();
//        toebehorens.add(toebehore);
//
//        Toebehoren toebehore2 = new Toebehoren("ZGGUHUH", "FFTFY235");
//        ArrayList<Toebehoren> toebehorens2 = new ArrayList<Toebehoren>();
//        toebehorens.add(toebehore2);
//
//        Toebehoren toebehore3 = new Toebehoren("FRW", "GGT45656");
//        toebehorens2.add(toebehore3);
//
//        Toebehoren toebehore4 = new Toebehoren("RT1", "BYYT78788U8");
//        toebehorens2.add(toebehore4);
//
//        Ornament ornament = new Ornament("ornamenet 34RR", "ornament200", "geel", true);
//        ArrayList<Ornament> ornamenten = new ArrayList<Ornament>();
//        ornamenten.add(ornament);
//
//        Ornament ornament2 = new Ornament("ornamenet HU876", "ornament781", "groen", true);
//        ArrayList<Ornament> ornamenten2 = new ArrayList<Ornament>();
//        ornamenten.add(ornament);
//
//        Aquarium aquarium1 = new Aquarium(bewoners, toebehorens, ornamenten,
//                "aquanatuur", 500, 40,8, "modder", "zuur");
//
//        Aquarium aquarium2 = new Aquarium(bewoners2, toebehorens, ornamenten,
//                "aquaovn", 110, 101,101, "zand", "zoet");
//
//        ArrayList<Aquarium> alleAquaria = new ArrayList<Aquarium>();
//        alleAquaria.add(aquarium1);
//        alleAquaria.add(aquarium2);
//
//
//        Eigenaar owner2 = aquaria.getAlleEigenaren().stream().filter(e -> e.getEmail().equals("haydar@gmail.com")).findFirst().orElse(null);
//        System.out.println(owner2.getEigenAquaria().size());
//
//        owner.setEigenAquaria(alleAquaria);

    }



    @Override

    public void contextDestroyed (ServletContextEvent sce)
    {

        try {
            PersisManager.saveToAzure();
            System.out.println( "Opslaan Azure");
        } catch (IOException e) {
            e.printStackTrace();
        }


        Schedulers.shutdownNow();
        HttpResources.disposeLoopsAndConnectionsLater(Duration.ZERO, Duration.ZERO).block();


    }
}