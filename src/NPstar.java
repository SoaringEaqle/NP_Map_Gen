
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Objects;



public class NPstar {


    public static boolean randReward = true;
    protected static int startEcon = 10;
    protected static int startIndus = 5;
    protected static int startSci = 2;
    protected static int startShip = 10;




    public static void setStartInfrastructure(int econ, int indus, int sci)
    {
        startEcon = econ;
        startIndus = indus;
        startSci = sci;
    }

    public static void updateArray(JSONObject starin) throws JSONException {
        con.stars.put(starin.getInt("uid")-1,starin);
    }


    public static class starHash{
        public static JSONObject NPcap(int starNum, double x, double y, int puid) throws JSONException {
            int resource = 50;
            int econ = NPstar.startEcon;
            int indus = NPstar.startIndus;
            int sci = NPstar.startSci;
            int gate = 1;
            int ship = NPstar.startShip;

            String name = NameGen.nextName();


            JSONObject star = new JSONObject();
            star.put("uid", starNum);
            star.put("name",name);
            star.put("x",x);
            star.put("y",y);
            star.put("resource",resource);
            star.put("economy",econ);
            star.put("industry",indus);
            star.put("science",sci);
            star.put("gate",gate);
            star.put("ship",ship);
            star.put("puid",puid);


            return star;
        }

        public static JSONObject NPclaimed(int starNum, double x, double y, int resource, int puid) throws JSONException {
            int econ = 0;
            int indus = 0;
            int sci = 0;


            int ship = NPstar.startShip;
            int gate = 0;


            String name = NameGen.nextName();

            JSONObject star = new JSONObject();
            star.put("uid", starNum);
            star.put("name",name);
            star.put("x",x);
            star.put("y",y);
            star.put("resource",resource);
            star.put("economy",econ);
            star.put("industry",indus);
            star.put("science",sci);
            star.put("gate",gate);
            star.put("ship",ship);
            star.put("puid",puid);


            return star;
        }

        public static JSONObject NPNotclaimed(int starNum, double x, double y, int resource) throws JSONException {


            int econ = 0;
            int indus = 0;
            int sci = 0;


            int ship = 0;
            int gate = 0;



            if(NPstar.randReward) {
                int num = con.rand.nextInt(20);
                switch (num) {
                    case 1:
                        econ = 5;
                        break;
                    case 2:
                        indus = 2;
                        break;
                    case 3:
                        sci = 1;
                        break;
                    case 4:
                        ship = con.rand.nextInt(15);
                        break;
                    case 5:
                        gate = 1;
                        break;
                    default:
                        break;
                }
            }



            String name = NameGen.nextName();

            JSONObject star = new JSONObject();
            star.put("uid", starNum);
            star.put("name",name);
            star.put("x",x);
            star.put("y",y);
            star.put("resource",resource);
            star.put("economy",econ);
            star.put("industry",indus);
            star.put("science",sci);
            star.put("gate",gate);
            star.put("ship",ship);

            return star;
        }
        public static void NPcust(int starNum) throws JSONException {
            System.out.print("Name (Type \"Random\" to randomly generate the name):");
            String name = con.inp.nextLine();
            if(name.equals("Random"))
            {
                name = NameGen.nextName();
            }
            System.out.print("x location: ");
            double x = con.inp.nextDouble();
            System.out.print("y location: ");
            double y = con.inp.nextDouble();

            System.out.print("resource value: ");
            int resource = con.inp.nextInt();

            System.out.print("economy: ");
            int econ = con.inp.nextInt();

            System.out.print("industry: ");
            int indus = con.inp.nextInt();

            System.out.print("science: ");
            int sci = con.inp.nextInt();

            System.out.print("Gate (0=false, 1=true): ");
            int gate = con.inp.nextInt();

            System.out.print("Starting Ships: ");
            int ship = con.inp.nextInt();

            System.out.print("puid (0 will return an unclaimed star): ");
            int puid = con.inp.nextInt();

            JSONObject star = new JSONObject();

            star.put("uid",starNum);
            star.put("name",name);
            star.put("x",x);
            star.put("y",y);
            star.put("resource",resource);
            star.put("economy",econ);
            star.put("industry",indus);
            star.put("science",sci);
            star.put("gate",gate);
            star.put("ship",ship);
            if (puid > 0){
                star.put("puid",puid);
            }
        }



        public static double starX(JSONObject star) throws JSONException {
            return (double) star.get("x");
        }
        public static double starY(JSONObject star) throws JSONException {
            return (double)star.get("y");
        }


    }
    public static class StarObj {
        private int econ;
        private int indus;
        private int sci;
        private int resource;
        private int ships;
        private int gate;
        private int uid;
        private int puid;
        private double starx;
        private double stary;
        private String name;

        HashMap<String, String> star = new HashMap<>();
        JSONObject starJ = new JSONObject();


        public void resetStarObj(JSONObject star) throws JSONException {
            uid = star.getInt("uid");
            name = star.getString("name");
            starx = star.getDouble("x");
            stary = star.getDouble("y");
            resource = star.getInt("resource");
            econ = star.getInt("economy");
            indus = star.getInt("industry");
            sci = star.getInt("science");
            ships = star.getInt("ship");
            gate = star.getInt("gate");
            puid = star.optInt("puid", 0);

            starJ = star;


        }

        public StarObj(int uid) throws JSONException {
            starJ = (JSONObject) con.stars.get(uid - 1);
            this.resetStarObj(starJ);

        }

        public StarObj(HashMap<String, String> star) {
            uid = Integer.parseInt(star.get("uid"));
            name = star.get("name");
            starx = Double.parseDouble(star.get("x"));
            stary = Double.parseDouble(star.get("y"));
            resource = Integer.parseInt(star.get("resource"));
            econ = Integer.parseInt(star.get("economy"));
            indus = Integer.parseInt(star.get("industry"));
            sci = Integer.parseInt(star.get("science"));
            ships = Integer.parseInt(star.get("ship"));
            gate = Integer.parseInt(star.get("gate"));
            puid = Integer.parseInt(star.getOrDefault("puid", "0"));

            this.star = star;
        }

        public StarObj(JSONObject star) throws JSONException {
            uid = star.getInt("uid");
            name = star.getString("name");
            starx = star.getDouble("x");
            stary = star.getDouble("y");
            resource = star.getInt("resource");
            econ = star.getInt("economy");
            indus = star.getInt("industry");
            sci = star.getInt("science");
            ships = star.getInt("ship");
            gate = star.getInt("gate");
            puid = star.optInt("puid", 0);


        }


        public void newName() {
            name = NameGen.newName();
        }

        public Object get(String key) throws JSONException {
            return starJ.get(key);
        }

        public JSONObject repackage() throws JSONException {
            starJ.put("uid", uid);
            starJ.put("name", name);
            starJ.put("x", starx);
            starJ.put("y", stary);
            starJ.put("resource", Integer.toString(resource));
            starJ.put("economy", Integer.toString(econ));
            starJ.put("industry", Integer.toString(indus));
            starJ.put("science", Integer.toString(sci));
            starJ.put("gate", Integer.toString(gate));
            starJ.put("ship", Integer.toString(ships));
            if (puid > 0) {
                starJ.put("puid", puid);
            }

            NPstar.updateArray(starJ);
            return starJ;
        }


        public boolean equals(StarObj starin) {
            return uid == starin.uid && name.equals(starin.name) &&
                    econ == starin.econ && indus == starin.indus && sci == starin.sci &&
                    resource == starin.resource &&
                    ships == starin.ships && gate == starin.gate &&
                    puid == starin.puid &&
                    starx == starin.starx && stary == starin.stary;
        }

        public boolean nameEqual(StarObj starin) {
            return uid != starin.uid && Objects.equals(name, starin.name);
        }

        public boolean cordsEqual(StarObj starin) {
            return uid != starin.uid && starx == starin.starx && stary == starin.stary;
        }
    }


    public static class WHMaker {
        public static JSONArray hole(int uid1, int uid2) {
            JSONArray hole = new JSONArray();
            hole.put(uid1);
            hole.put(uid2);
            return hole;
        }

    }
}
