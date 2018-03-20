
package finalprojectB;

import junit.framework.TestCase;
import java.util.Random;
import java.util.*;


//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!


public class UrlValidatorTest extends TestCase {

   UrlValidator checkValid = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);


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

   //test scheme / authority / path partition
   public void testYourFirstPartition()
   {
      //You can use this function to implement your First Partition testing
      UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

      // part of url partition
      assertTrue(urlVal.isValid("http://www.google.com/test1"));
      assertFalse(urlVal.isValid("http:go/test1"));
      assertFalse(urlVal.isValid("ftp:65535/aaa"));
      assertTrue(urlVal.isValid("http://255.com/t123"));

      //testing url bad partition
      assertFalse(urlVal.isValid("ftp:google.com"));
      assertFalse(urlVal.isValid("http://aaa/.."));
      assertFalse(urlVal.isValid("http://aaa:-1/$23"));
      assertFalse(urlVal.isValid("https"));

   }

   public void testYourSecondPartition(){
      //You can use this function to implement your Second Partition testing

      UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

      // testing good url partition
      assertTrue(urlVal.isValid("http://www.google.com/#/test1?action=view"));
      assertTrue(urlVal.isValid("http://go.com/t123?action=edit&mode=up"));
      assertTrue(urlVal.isValid("http://www.go.com/#/$23?action=view"));

      // testing bad url partition
      assertFalse(urlVal.isValid("://1.2.3.4.:65a/.."));
      assertFalse(urlVal.isValid("://aaa.:-1/..//file1/../"));
      assertFalse(urlVal.isValid("http/1.2.3:-50/../"));

   }
   //You need to create more test cases for your Partitions if you need to


   public void testIsValid() {
      //You can use this function for programming based testing
      UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
      int schemeLength = testUrlScheme.length;
      int authorityLength = testUrlAuthority.length;
      int portLength = testUrlPort.length;
      int pathLength = testPath.length;
      int pathoptionLength = testUrlPathOptions.length;
      int queryLength = testUrlQuery.length;
      int arrayLength[] = new int[]{schemeLength, authorityLength, portLength, pathLength, queryLength};

      int index;
      String tempURL;
      String checkURL;
      Boolean expected;
      Boolean testValid;

      Random rand = new Random();

      while (true) {
         tempURL = "";
         checkURL = "";
         testValid = true;

         // test 5 length
         for(int i = 0; i < 5; i++) {
            index = rand.nextInt(arrayLength[i]);
            ResultPair[] part = (ResultPair[]) testUrlParts[i];
            tempURL += part[index].item;
            if (part[index].valid == false) {
               testValid = false;
            }
         }
         expected = urlVal.isValid(tempURL);
         assertEquals(expected, testValid);

         if (testValid) {
            checkURL += "Valid";
         } else {
            checkURL += "Invalid";
         }

         System.out.println(tempURL + " " + checkURL + " URL ");

      }
   }



   /**
    A complete URL is composed of a scheme + authority + port + path + query,
    * all of which must be individually valid for the entire URL to be considered
    * valid.
    * @param testObjects to be used to create a url.
    */
   ResultPair[] testUrlScheme = {
           new ResultPair("http://", true),
           new ResultPair("ftp://", true),
           new ResultPair("h3t://", true),
           new ResultPair("3ht://", false),
           new ResultPair("http:/", false),
           new ResultPair("http:", false),
           new ResultPair("http/", false),
           new ResultPair("://", false),
           new ResultPair("", true)
   };

   ResultPair[] testUrlAuthority = {
           new ResultPair("www.google.com", true),
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

   Object[] testUrlParts = {testUrlScheme, testUrlAuthority, testUrlPort, testPath, testUrlQuery};
   Object[] testUrlPartsOptions = {testUrlScheme, testUrlAuthority, testUrlPort, testUrlPathOptions, testUrlQuery};
   int[] testPartsIndex = {0, 0, 0, 0, 0};

   //---------------- Test data for individual url parts ----------------
   ResultPair[] testScheme = {new ResultPair("http", true),
           new ResultPair("ftp", false),
           new ResultPair("httpd", false),
           new ResultPair("telnet", false)};


}