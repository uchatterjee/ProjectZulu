package twitter.extract.data;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.json.DataObjectFactory;

import java.io.*;
import java.util.List;


public class TwitterExtractQuery {
	static int count = 1;
 
    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
/*        if (args.length < 1) {
            System.out.println("java twitter4j.examples.search.SearchTweets [query]");
            System.exit(-1);
        }
*/      

    	//FileWriter tweetOutput = new FileWriter();
    	PrintStream out = new PrintStream(new FileOutputStream("/Users/utsavchatterjee/Documents/New Java Workspace/ProjectZulu/TwitterExtractData/iMac.txt"));
    	System.setOut(out);
    	
    	ConfigurationBuilder cb = new ConfigurationBuilder();
    	cb.setJSONStoreEnabled(true);
    	cb.setDebugEnabled(true)
    	  .setOAuthConsumerKey("AmVQjPCNFO4OgAeZrUpVg")
    	  .setOAuthConsumerSecret("k3W3vyHcvS7Y6wjyyJJTz18JzVpE7LzR3WJf8r768")
    	  .setOAuthAccessToken("1373683584-CvQLfsDpRtUKVgpQAhemsC1H5X09bCGrnWNb4Cl")
    	  .setOAuthAccessTokenSecret("QYFdezGcx290B3wQjw460PyS4n0UTki5KAVRpUFaHcT0r");
    	
    	TwitterFactory tf = new TwitterFactory(cb.build());
    	Twitter twitter = tf.getInstance();
    	
        try {
            Query query = new Query("#iMac");
            query.setCount(1500);
       
            QueryResult result;
            do {
                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
                //count += tweets.size();
                //System.out.println(count);
/*                if(count == 1000){
                	Thread.sleep(6000);
                	
                }
*/                //System.out.println(count);
                //int count = 0;
                for (Status tweet : tweets) {
                	//System.out.println(count);
                    //System.out.println(count + " @" + tweet.getUser().getScreenName() + " - " + tweet.getText());
                    //System.out.println(tweet.getId());
                    //System.out.println(tweet.getSource());
                	//System.out.println(tweet.getRetweetedStatus());
                	count += 1;

                    //System.out.println(count);
                    System.out.println(tweet.getUser() + ":" + tweet.getText());
                	String json = DataObjectFactory.getRawJSON(tweet);
                    System.out.println(json);
                }
                
                System.out.println("Final count: "+ (count-1));
            } while ((query = result.nextQuery()) != null);
            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
        }
        
    }
}