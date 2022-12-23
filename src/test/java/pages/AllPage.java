package pages;

public class AllPage {

    public AllPage() {}
        private Checked checked;

        public Checked checked() {
            if (checked == null) {
                checked = new Checked();
            }
            return checked;
        }




}
