/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.DistributorRole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class JSONDistanceCalculator 
{
 static String beg,end;
 static StringBuffer start=new StringBuffer(), stop=new StringBuffer();
 static float totDistance;
 public String calculate(String s, String d)
 {
  JSONInterface ji=new JSONInterface();
  //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  try
  {
   //System.out.println("Enter the source place : ");
   beg=s;
   //System.out.println("Enter the distance place : ");
   end=d;
   start.append(beg);
   stop.append(end);
   for(int i=0; i<start.length(); i++)
   {
    if(start.charAt(i)==' ')
    {
     start.deleteCharAt(i);
     start.insert(i, "%20");
    }
   }
   for(int i=0;i<stop.length();i++)
   {
    if(stop.charAt(i)==' ')
    {
     stop.deleteCharAt(i);
     stop.insert(i, "%20");
    }
   }
   totDistance=ji.calcDistance(start,stop);
   System.out.println("The distance between "+beg+" and "+end+" is = "+totDistance);
  }
  catch(Exception e)
  {
   System.out.println("Json type exception");
   e.printStackTrace();
  }
  String ans = "The distance between "+beg+" and "+end+" is = "+totDistance;
  return ans;
 }
}