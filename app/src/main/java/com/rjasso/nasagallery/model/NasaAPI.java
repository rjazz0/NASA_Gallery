package com.rjasso.nasagallery.model;

public class NasaAPI {
String identifier;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public CentroidCoordinates getCentroid_coordinates() {
        return centroid_coordinates;
    }

    public void setCentroid_coordinates(CentroidCoordinates centroid_coordinates) {
        this.centroid_coordinates = centroid_coordinates;
    }

    String caption;
    String image;
    String version;
    CentroidCoordinates centroid_coordinates;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    String date;


}

   /*           "identifier":"20190627021926",
              "caption":"This image was taken by NASAs EPIC camera onboard the NOAA DSCOVR spacecraft",
              "image":"epic_1b_20190627021926",
              "version":"02",
              "CentroidCoordinates":{ 
                 "lat":19.335778000000001,
                 "lon":148.15378799999999
              },
              "dscovr_j2000_position":{ 
                 "x":-204764.15546899999,
                 "y":1493138.9563219999,
                 "z":531008.56119200005
              },
              "lunar_j2000_position":{ 
                 "x":360469.68125000002,
                 "y":159703.51456499999,
                 "z":-36168.148822000003
              },
              "sun_j2000_position":{ 
                 "x":-13037972.400064999,
                 "y":139016226.16424799,
                 "z":60262913.573174998
              },
              "attitude_quaternions":{ 
                 "q0":0.74644999999999995,
                 "q1":-0.59384999999999999,
                 "q2":-0.28858,
                 "q3":0.082949999999999996
              },
              "date":"2019-06-27 02:14:37",
              "coords":{ 
                 "CentroidCoordinates":{ 
                    "lat":19.335778000000001,
                    "lon":148.15378799999999
                 },
                 "dscovr_j2000_position":{ 
                    "x":-204764.15546899999,
                    "y":1493138.9563219999,
                    "z":531008.56119200005
                 },
                 "lunar_j2000_position":{ 
                    "x":360469.68125000002,
                    "y":159703.51456499999,
                    "z":-36168.148822000003
                 },
                 "sun_j2000_position":{ 
                    "x":-13037972.400064999,
                    "y":139016226.16424799,
                    "z":60262913.573174998
                 },
                 "attitude_quaternions":{ 
                    "q0":0.74644999999999995,
                    "q1":-0.59384999999999999,
                    "q2":-0.28858,
                    "q3":0.082949999999999996
                 }
              }
           },*/
