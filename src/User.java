import java.time.LocalDate;

class User {
    private String username;
    private int penaltyPoints;
    private LocalDate penaltyExpirationDate;

    public User(String username) {
        this.username = username;
        this.penaltyPoints = 0;
        this.penaltyExpirationDate = LocalDate.now();
    }

    public String getUsername() {
        return username;
    }

    public int getPenaltyPoints() {
        return penaltyPoints;
    }

    public LocalDate getPenaltyExpirationDate(LocalDate localDate) {
        return penaltyExpirationDate;
    }

    public void increasePenaltyPoints(int points) {
        penaltyPoints += points;
        if (penaltyPoints >= 10) {
            penaltyExpirationDate = LocalDate.now().plusMonths(1);
            penaltyPoints = 0;
        }
    }

    public void resetPenaltyPoints() {
        penaltyPoints = 0;
        penaltyExpirationDate = LocalDate.now();
    }
}