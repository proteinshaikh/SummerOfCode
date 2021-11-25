package DesignPatterns.BuilderDesignPattern;

public class Phone {
    private String panel;
    private String camera;
    private String processor;

    public static class Builder {

        private String panel;
        private String camera;
        private String processor;

        public Builder() {

        }

        public Phone build() {
            return new Phone(this);
        }

        public Builder setPanel(String panel) {
            this.panel = panel;
            return this;
        }

        public Builder setCamera(String camera) {
            this.camera = camera;
            return this;
        }

        public Builder setProcessor(String processor) {
            this.processor = processor;
            return this;
        }
    }

    private Phone(Builder builder) {
        this.camera = builder.camera;
        this.panel = builder.panel;
        this.processor = builder.processor;
    }


    public String getPanel() {
        return panel;
    }

    public String getCamera() {
        return camera;
    }

    public String getProcessor() {
        return processor;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Phone{");
        sb.append("panel='").append(panel).append('\'');
        sb.append(", camera='").append(camera).append('\'');
        sb.append(", processor='").append(processor).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
