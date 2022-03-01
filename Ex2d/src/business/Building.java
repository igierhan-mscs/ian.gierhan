package business;
import java.time.LocalDateTime;

public class Building {
    private int buildingId;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String units;
    private LocalDateTime updated = LocalDateTime.now();

    public Building() {
        this.buildingId = 0;
        this.address = "";
        this.city = "";
        this.state = "";
        this.zip = "";
        this.units = "";
    }

    public Building(int buildingId, String address, String city, String state, String zip, String units) {
        this.buildingId = buildingId;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.units = units;
    }

    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) { this.units = units; }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated() {
        this.updated = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return  "Building:" +
                "\n\tBuilding Id:\t" + buildingId +
                "\n\tAddress:\t\t" + address +
                "\n\tCity:\t\t\t" + city +
                "\n\tState:\t\t\t" + state +
                "\n\tZip:\t\t\t" + zip +
                "\n\tUnits:\t\t\t" + units +
                "\n\tUpdated:\t\t" + updated;
    }
}
