package io.github.xico26;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<String> awLines;
    private List<String> loaLines;
    private List<String> removedLines;
    private List<String> leftLines;

    public Controller() {
        this.awLines = new ArrayList<String>();
        this.loaLines = new ArrayList<String>();
        this.removedLines = new ArrayList<String>();
        this.leftLines = new ArrayList<String>();
    }

    public void addLine (String driverId, String discordUrl, int option) {
        // discord://-/users/ID

        String discordId = discordUrl.substring(18);

        String line = "> - " + driverId + " - <@" + discordId + ">";

        switch (option) {
            case 0:
                this.awLines.add(line);
                break;
            case 1:
                this.loaLines.add(line);
                break;
            case 2:
                this.removedLines.add(line);
                break;
            case 3:
                this.leftLines.add(line);
                break;
            default:
                System.err.println("Invalid option");
        }

        System.out.println(line);
    }

    public void printAll() {
        System.out.println("❌ **Didn't meet quota > AW issued**");
        for (String line : awLines) {
            System.out.println(line);
        }
        System.out.println("⛱️ **LOA**");
        for (String line : loaLines) {
            System.out.println(line);
        }
        System.out.println("👢 **Removed**");
        for (String line : removedLines) {
            System.out.println(line);
        }
        System.out.println("🚪 **Left**");
        for (String line : leftLines) {
            System.out.println(line);
        }
    }
}
