package ru.job4j.stream.builder;

/**
 * 9. Шаблоны проектирования в Stream API.
 * Практическое закрепление знаний.
 */
public class Notebook {
    private String model;
    private byte cores;
    private int ram;
    private String videoCard;
    private boolean backlit;

    @Override
    public String toString() {
        return "Notebook{"
                + "model='" + model + '\''
                + ", cores=" + cores
                + ", ram=" + ram
                + ", videoCard='" + videoCard + '\''
                + ", backlit=" + backlit
                + '}';
    }

    public static class Builder {
        private String model;
        private byte cores;
        private int ram;
        private String videoCard;
        private boolean backlit;

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildCores(byte cores) {
            this.cores = cores;
            return this;
        }

        Builder buildRam(int ram) {
            this.ram = ram;
            return this;
        }

        Builder buildVideoCard(String videoCard) {
            this.videoCard = videoCard;
            return this;
        }

        Builder buildBacklit(boolean backlit) {
            this.backlit = backlit;
            return this;
        }

        Notebook build() {
            Notebook note = new Notebook();
            note.model = model;
            note.cores = cores;
            note.ram = ram;
            note.videoCard = videoCard;
            note.backlit = backlit;
            return note;
        }
    }

    public static void main(String[] args) {
        Notebook note = new Builder()
                .buildModel("DELL")
                .buildCores((byte) 4)
                .buildRam(4)
                .buildBacklit(true)
                .build();
        System.out.println(note);
        Notebook noteFX = new Builder()
                .buildModel("DNS")
                .buildCores((byte) 8)
                .buildVideoCard("Radeon HD7770")
                .build();
        System.out.println(noteFX);
    }
}
