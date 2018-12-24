public class Order {

    private String startDate;
    private String endDate;
    private String name;
    private String secondName;
    private String telNum;
    private int parkingSeatID;

    Order(String name, String secondName,
          String telNum, String startDate,
          String endDate, int parkingSeatID){

        this.name = name;
        this.secondName = secondName;
        this.telNum = telNum;
        this.startDate = startDate;
        this.endDate = endDate;
        this.parkingSeatID = parkingSeatID;

    }


    public void showInfo(){

        System.out.println(startDate + " -" +
                " " + endDate + "\nФИ: " +
                secondName + " " + name + "\nНомер телефона: " +
                telNum + "\n~~~~~~~~~~~~~~~~~~~~~~~~~");

    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getTelNum() {
        return telNum;
    }

    public int getParkingSeatID() {
        return parkingSeatID;
    }
}
