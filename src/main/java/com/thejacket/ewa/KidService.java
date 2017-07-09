package com.thejacket.ewa;

/**
 * Created by mariusz on 2017-06-21.
 */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KidService {

    private static KidService instance;

    private final HashMap<Long, Kid> kidData = new HashMap<>();
    private long nextId = 0;


    public static KidService getInstance() {
        if (instance == null) {
            instance = new KidService();
            instance.populateWithData();
        }
        return instance;
    }


    public List<Kid> findAll() {
        return findAll(null);
    }


    public List<Kid> findAll(String stringFilter) {
        ArrayList<Kid> arrayList = new ArrayList<>();
        for (Kid contact : kidData.values()) {
            try {
                boolean passesFilter = (stringFilter == null || stringFilter.isEmpty())
                        || contact.toString().toLowerCase().contains(stringFilter.toLowerCase());
                if (passesFilter) {
                    arrayList.add(contact.clone());
                }
            } catch (CloneNotSupportedException ex) {
            }
        }
        Collections.sort(arrayList, new Comparator<Kid>() {
            @Override
            public int compare(Kid k1, Kid k2) {
                return (int) (k2.getId() - k1.getId());
            }
        });
        return arrayList;
    }

    public List<Kid> findAll(String stringFilter, int start, int maxresults) {
        ArrayList<Kid> arrayList = new ArrayList<>();
        for (Kid contact : kidData.values()) {
            try {
                boolean passesFilter = (stringFilter == null || stringFilter.isEmpty())
                        || contact.toString().toLowerCase().contains(stringFilter.toLowerCase());
                if (passesFilter) {
                    arrayList.add(contact.clone());
                }
            } catch (CloneNotSupportedException ex) {
            }
        }
        Collections.sort(arrayList, new Comparator<Kid>() {

            @Override
            public int compare(Kid k1, Kid k2) {
                return (int) (k2.getId() - k1.getId());
            }
        });
        int end = start + maxresults;
        if (end > arrayList.size()) {
            end = arrayList.size();
        }
        return arrayList.subList(start, end);
    }


    public long count() {
        return kidData.size();
    }


    public void delete(Kid value) {
        kidData.remove(value.getId());
    }


    public void save(Kid entry) {
        if (entry.getId() == null) {
            entry.setId(nextId++);
        }
        try {
            entry = (Kid) entry.clone();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        kidData.put(entry.getId(), entry);
    }


    public void populateWithData() {
        if (findAll().isEmpty()) {
            final String[] names = new String[] { "Jan Kowalski", "Adam Nowak", "Robin Hood",
                    "Cat Woman", "Roger Waters", "Mariusz Błaszczak", "Donald Trump", "Oberek Obieżyświat",
                    "Steve Wozniak", "Zbigniew Stonoga", "Linus Torvalds", "Borja Gil", "Kelly Gustavsson",
                    "Theresa May", "Tadeusz Nowak", "Michaella Tabb", "Ronnie O'Sullivan", "Will Smith",
                    "Anne Heche", "East Africa", "Ludzka Stonoga", "Jamar Olsson", "Lara Croft",
                    "Ann Andersson", "Twoja stara", "Tomb Raider", "Przemysław Wipler", "Pije Kawe",
                    "Nabfffzdyczony Nabuchodonozor", "Adam Smith" };
            Random r = new Random(0);
            int index = 0;
            for (String name : names) {
                String[] split = name.split(" ");
                Kid k = new Kid();
                k.setFirstName(split[0]);
                k.setLastName(split[1]);
                k.setStatus(QuestionnaireData.wasSick.values()[r.nextInt(QuestionnaireData.wasSick.values().length)]);
                k.setSex(QuestionnaireData.sex.values()[r.nextInt(QuestionnaireData.sex.values().length)]);
                k.setKidCode("DZIECKO-" + split[0].substring(0,2) + "-" + index);
                k.setPreStoryNo1Time(new Float(1));
                k.setPostStoryNo1Time(new Float(1));
                k.setPreStoryNo2Time(new Float (r.nextInt(300)));
                k.setPostStoryNo2Time(new Float (r.nextInt(300)));
                int daysOld = 0 - r.nextInt(365 * 10);
                k.setBirthDate(LocalDate.now().plusDays(daysOld));
                save(k);
                index++;
            }
        }
    }

}