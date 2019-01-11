package com.example.dhruvik.iris_interview;

import java.util.ArrayList;

public  class DataHelper {

    //this Array list store the data about company,type,dates,urls.

    public static ArrayList<String> company_name = new ArrayList<String>();
    public static ArrayList<String> company_type = new ArrayList<String>();
    public static ArrayList<String>  rec_date = new ArrayList<String>();
    public static ArrayList<String>  ded_date = new ArrayList<String>();
    public static ArrayList<String>  company_url = new ArrayList<String>();
    public static ArrayList<String>  rec_type = new ArrayList<String>();

    //this array list stores all company detail which applied by user

    public static ArrayList<String>  applied_company_name = new ArrayList<String>();
    public static ArrayList<String>  applied_company_type = new ArrayList<String>();
    public static ArrayList<String>  applied_rec_date = new ArrayList<String>();
    public static ArrayList<String>  applied_ded_date = new ArrayList<String>();
    public static ArrayList<String>  applied_rec_type = new ArrayList<String>();
    public static ArrayList<Integer> applied_company_index = new ArrayList<Integer>();
}
