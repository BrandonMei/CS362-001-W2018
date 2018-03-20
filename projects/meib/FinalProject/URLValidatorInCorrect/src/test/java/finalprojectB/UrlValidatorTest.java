
package finalprojectB;

import junit.framework.TestCase;
import java.util.Random;


//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!


public class UrlValidatorTest extends TestCase {

   private final boolean printStatus = false;
   private final boolean printIndex = false;//print index that indicates current scheme,host,port,path, query test were using.


   public UrlValidatorTest(String testName) {
      super(testName);
   }


   public void testManualTest01()
   {
      //You can use this function to implement your manual testing
      UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
      assertTrue(urlVal.isValid("http://www.google.com"));
      System.out.println(urlVal.isValid("http://www.google.com"));

      assertTrue(urlVal.isValid("http://www.twitter.com/"));
      System.out.println(urlVal.isValid("http://www.twitter.com/"));

      System.out.println(urlVal.isValid("google.do"));
      System.out.println(urlVal.isValid("www./CS.com"));

   }

   public void testManualTest02()
   {
      //You can use this function to implement your manual testing
      String[] schemes = {"http","https"};
      UrlValidator urlVal2 = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
      assertTrue(urlVal2.isValid("https://www.youtube.com/channel/UC-9-kyTW8ZkZNDHQJ6FgpwQ"));
      System.out.println(urlVal2.isValid("https://www.youtube.com/channel/UC-9-kyTW8ZkZNDHQJ6FgpwQ"));
      System.out.println(urlVal2.isValid("ttps://www.google.com"));

   }

   public void testManualTest03()
   {
      //You can use this function to implement your manual testing
      UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
      assertTrue(urlVal.isValid("https://www.google.com/search?q=maps&cad=h"));
      System.out.println(urlVal.isValid("https://www.google.com/search?q=maps&cad=h"));

   }


   public void testYourFirstPartition()
   {
      //You can use this function to implement your First Partition testing
      UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
      assertTrue(urlVal.isValid("www.youtube.com/feed/trending"));
      System.out.println(urlVal.isValid("www.youtube.com/feed/trending"));


   }

   public void testYourSecondPartition(){
      //You can use this function to implement your Second Partition testing









   }

   //You need to create more test cases for your Partitions if you need to

   public void testYourThirdPartition(){
      //You can use this function to implement your Second Partition testing




   }

   public void testIsValid()
   {
      //You can use this function for programming based testing
      UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);





   }


   /**
    A complete URL is composed of a scheme + authority + port + path + query,
    * all of which must be individually valid for the entire URL to be considered
    * valid.
    * @param testObjects to be used to create a url.
    */
   ResultPair[] testUrlScheme = {new ResultPair("http://", true),
                               new ResultPair("ftp://", true),
                               new ResultPair("h3t://", true),
                               new ResultPair("3ht://", false),
                               new ResultPair("http:/", false),
                               new ResultPair("http:", false),
                               new ResultPair("http/", false),
                               new ResultPair("://", false),
                               new ResultPair("", true)};

   ResultPair[] testUrlAuthority = {new ResultPair("www.google.com", true),
                                 new ResultPair("go.com", true),
                                 new ResultPair("go.au", true),
                                 new ResultPair("0.0.0.0", true),
                                 new ResultPair("255.255.255.255", true),
                                 new ResultPair("256.256.256.256", false),
                                 new ResultPair("255.com", true),
                                 new ResultPair("1.2.3.4.5", false),
                                 new ResultPair("1.2.3.4.", false),
                                 new ResultPair("1.2.3", false),
                                 new ResultPair(".1.2.3.4", false),
                                 new ResultPair("go.a", false),
                                 new ResultPair("go.a1a", false),
                                 new ResultPair("go.1aa", false),
                                 new ResultPair("aaa.", false),
                                 new ResultPair(".aaa", false),
                                 new ResultPair("aaa", false),
                                 new ResultPair("", false)
   };
   ResultPair[] testUrlPort = {new ResultPair(":80", true),
                            new ResultPair(":65535", true),
                            new ResultPair(":0", true),
                            new ResultPair("", true),
                            new ResultPair(":-1", false),
                            new ResultPair(":65636",false),
                            new ResultPair(":65a", false)
   };
   ResultPair[] testPath = {new ResultPair("/test1", true),
                          new ResultPair("/t123", true),
                          new ResultPair("/$23", true),
                          new ResultPair("/..", false),
                          new ResultPair("/../", false),
                          new ResultPair("/test1/", true),
                          new ResultPair("", true),
                          new ResultPair("/test1/file", true),
                          new ResultPair("/..//file", false),
                          new ResultPair("/test1//file", false)
   };
   //Test allow2slash, noFragment
   ResultPair[] testUrlPathOptions = {new ResultPair("/test1", true),
                                   new ResultPair("/t123", true),
                                   new ResultPair("/$23", true),
                                   new ResultPair("/..", false),
                                   new ResultPair("/../", false),
                                   new ResultPair("/test1/", true),
                                   new ResultPair("/#", false),
                                   new ResultPair("", true),
                                   new ResultPair("/test1/file", true),
                                   new ResultPair("/t123/file", true),
                                   new ResultPair("/$23/file", true),
                                   new ResultPair("/../file", false),
                                   new ResultPair("/..//file", false),
                                   new ResultPair("/test1//file", true),
                                   new ResultPair("/#/file", false)
   };

   ResultPair[] testUrlQuery = {new ResultPair("?action=view", true),
                             new ResultPair("?action=edit&mode=up", true),
                             new ResultPair("", true)
   };



}
