package reporting;

import order.domain.Order;

import java.io.*;

public class Report {
    public static final String FILE_PATH = "/Users/boits/IdeaProjects/Epam/Tourism2/ReportOrders";

    public static void createOrder(Order order) {

        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            writer.append("Create order: ");
            writer.write(order.toString());
            writer.append('\n');

            writer.flush();

        } catch (IOException e) {
        }
    }

    public static void deleteOrder(Order order) {

        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            writer.append("Delete order: ");
            writer.write(order.toString());
            writer.append('\n');

            writer.flush();

        } catch (IOException e) {
        }
    }
}
