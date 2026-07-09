package programming.drsean.maps;

import java.util.*;

public class App {

    public static void main(String[] args) {
        Map<String, Integer> channelToSubscribers
                = new TreeMap<>(); // channelName, numSubscribers
        Map<String, String> channelToPublisher
                = new TreeMap<>(); // channelName, publisher
        Map<String, Integer> publisherToSubscribers
                = new TreeMap<>(); // publisher, numSubscribers
// channel -> number of subscribers (K, V1)
        channelToSubscribers.put("JustForLaughs", 120_000);
        channelToSubscribers.put("JustForGags", 10_000);
        channelToSubscribers.put("ContemplationTechniques", 10_000);
        channelToSubscribers.put("A New Earth", 20_000);
// channel -> publisher (K, V2)
        channelToPublisher.put("JustForLaughs", "Charlie Chaplin");
        channelToPublisher.put("JustForGags", "Charlie Chaplin");
        channelToPublisher.put("ContemplationTechniques", "Echhart Tolle");
        channelToPublisher.put("A New Earth", "Echhart Tolle");


        channelToPublisher.forEach((channel, publisher) -> {
            // Option 1 Failed, replace values instead of adding them
            //publisherToSubscribers.put(publisher, channelToSubscribers.get(channel));

            // Option 2 OK
            /*
            publisherToSubscribers.compute(publisher, (sameChannel, currentSubscribers) -> {
                Integer newSubscribers = channelToSubscribers.get(channel);
                return currentSubscribers == null ? newSubscribers : currentSubscribers + newSubscribers;
            });
             */

            // Option 3 OK
            publisherToSubscribers.merge(publisher, channelToSubscribers.get(channel), Integer::sum);
        });


        publisherToSubscribers.forEach((channel, subscribers) ->
                System.out.println("publisher:" +channel + "; numSubscribers: " + subscribers));

        String keyMax = Collections.max(publisherToSubscribers.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("Publisher with most subscribers: " + keyMax + " " +  publisherToSubscribers.get(keyMax));

        String keyMin = Collections.min(publisherToSubscribers.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("Publisher with fewest subscribers: " + keyMin + " " +  publisherToSubscribers.get(keyMax));

    }
}
