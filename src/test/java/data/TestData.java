package data;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "invalid login credentials")
    public Object[][] getInvalidData() {
        return new Object[][] {
                {"admin1", "invalidPass1"},
                {"admin2", "invalidPass2"},
                {"admin3", "invalidPass3"},
                {"admin4", "invalidPass4"},
                {"admin5", "invalidPass5"},
                {"admin6", "invalidPass6"}
        };
    }

    @DataProvider(name = "patient info")
    public Object[][] getPatient() {
        return new Object[][] {
                {"John", "Doe", 1, "22/03/1980", "Test address"}
        };
    }
}
