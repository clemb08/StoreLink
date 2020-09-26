package org.kenavo.finder.services;

import com.alibaba.fastjson.JSON;
import org.kenavo.finder.Main;
import org.kenavo.finder.models.Link;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LinkService {

    public void createLink(Link link) {
        File file = new File("src/resources/links/links.txt");
        String jsonLink = JSON.toJSONString(link);
        Main.links.add(link);

        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            System.out.println(jsonLink);
            bw.write(jsonLink);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Link> findAllLinks() {
        Path path = Path.of("src/resources/links/links.txt");
        boolean exists = Files.exists(path);

        if(exists)
            try (BufferedReader reader =
                         Files.newBufferedReader(path, StandardCharsets.UTF_8)) {

                String line = reader.readLine();
                List<Link> links = new ArrayList<>();
                while (line != null) {
                    System.out.println("Line = " + line);
                    Link link = JSON.parseObject(line, Link.class);
                    System.out.println(link);
                    links.add(link);
                    line = reader.readLine();
                }
                return links;
            } catch (IOException e) {
                e.printStackTrace();
            }
        return null;
    }

    public Link findById(String id){
        List<Link> links = Main.links;
        Link foundLink = new Link();
        for (Link link : links) {
            if (link.getId().equals(id))
                foundLink = link;
        }
        return foundLink;
    }

    public int findIndex(Link link){
        List<Link> links = Main.links;
        return links.indexOf(link);
    }

    public void refreshLinks(List<Link> links){
        File file = new File("src/resources/links/links.txt");
        file.delete();

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Link link : links) {
                String jsonLink = JSON.toJSONString(link);
                System.out.println(jsonLink);
                bw.write(jsonLink);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
