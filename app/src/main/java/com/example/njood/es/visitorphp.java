package com.example.njood.es;


public class visitorphp extends visitorchanges {
    String URL = "http://192.168.100.13/ES/visitor.php";
    String url = "";
    String response = "";

    public String tampilBiodata() {
        try {
            url = URL + "?operation=view";
            System.out.println("URL Tampil visitorphp: " + url);
            response = call(url);
        } catch (Exception e) {
        }
        return response;
    }

    public String inserBiodata(String name, String refnum , String number) {
        try {

            name = name.replace(" ", "%20");
            refnum = refnum.replace(" ", "%20");
            number = number.replace(" ", "%20");

            url = URL + "?operation=insert&name =" + name + "&Refnum=" + refnum + "&Number=" + number;
            System.out.println("URL Insert visitorphp : " + url);
            response = call(url);
        } catch (Exception e) {
        }
        return response;
    }

    public String getBiodataById(int id) {
        try {
            url = URL + "?operation=get_biodata_by_id&id=" + id;
            System.out.println("URL Insert visitorphp : " + url);
            response = call(url);
        } catch (Exception e) {
        }
        return response;
    }

    public String updateBiodata(String id, String name, String refnum, String number) {
        try {

            name = name.replace(" ", "%20");
            refnum = refnum.replace(" ", "%20");
            number = number.replace(" ", "%20");

            url = URL + "?operation=update&id=" + id + "&name=" + name + "&Refnum=" + refnum + "&Number=" + number;
            System.out.println("URL Insert visitorphp : " + url);
            response = call(url);
        } catch (Exception e) {
        }
        return response;
    }

    public String deleteBiodata(int id) {
        try {
            url = URL + "?operation=delete&id=" + id;
            System.out.println("URL Insert visitorphp : " + url);
            response = call(url);
        } catch (Exception e) {
        }
        return response;
    }
}

