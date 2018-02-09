package prettyMuchEverything;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Controller {
	@FXML
	private TabPane overview;
	@FXML
	private Tab homeTab;
	@FXML
	private Button endDay;
	@FXML
	private TextField dayNum;
	@FXML
	private TextField homeProgress;
	@FXML
	private TextField homeWeight;
	@FXML
	private TextField homeBMI;
	@FXML
	private TextField homeSleep;
	@FXML
	private TextField homeExcercise;
	@FXML
	private TextField homeDiet;
	@FXML
	private TextField homeWater;
	@FXML
	private ImageView healthBot ;
	@FXML
	private TextArea botText;
	@FXML
	private Tab weightTab;
	@FXML
	private Button weightSet;
	@FXML
	private TextField weightText;
	@FXML
	private CategoryAxis weightX;
	@FXML
	private NumberAxis weightY;
	@FXML
	private LineChart<?, ?> weightChart;
	@FXML
	private Tab bMITab;
	@FXML
	private CategoryAxis bmiX;
	@FXML
	private NumberAxis bmiY;
	@FXML
	private LineChart<?, ?> bMIChart;
	@FXML
	private Tab sleepTab;
	@FXML
	private Button sleepSet;
	@FXML
	private TextField sleepText;
	@FXML
	private CategoryAxis sleepX;
	@FXML
	private NumberAxis sleepY;
	@FXML
    private LineChart<?, ?> sleepChart;
	@FXML
	private Tab excerciseTab;
	@FXML
	private Button excerciseSet;
	@FXML
	private TextField excerciseText;
	@FXML
	private CategoryAxis excerciseX;
	@FXML
	private NumberAxis excerciseY;
	@FXML
	private LineChart<?, ?> excerciseChart;
	@FXML
	private Tab dietTab;
	@FXML
	private Button dietSet;
	@FXML
	private TextField dietText;
	@FXML
	private CategoryAxis dietX;
	@FXML
	private NumberAxis dietY;
	@FXML
	private LineChart<?, ?> dietChart;
	@FXML
	private Tab waterTab;
	@FXML
	private Button waterSet;
	@FXML
	private TextField waterText;
	@FXML
	private CategoryAxis waterX;
	@FXML
	private NumberAxis waterY;
	@FXML
	private LineChart<?, ?> waterChart;
	@FXML
	private Tab goalsTab;
	@FXML
	private TextField goalWeight;
	@FXML
	private Button gwSet;
	@FXML
	private TextField goalBMI;
	@FXML
	private Button gBMISet;
	@FXML
	private TextField goalSleep;
	@FXML
	private Button gsSet;
	@FXML
	private TextField goalExcercise;
	@FXML
	private Button geSet;
	@FXML
	private TextField goalDiet;
	@FXML
	private Button gdSet;
	@FXML
	private TextField goalWater;
	@FXML
	private Button gwaterSet;
	@FXML
	private Button advice;
	@FXML
	private Button setHeight;
	@FXML
	private TextField heightBox;

	StatTracker weight;
	StatTracker bmi;
	StatTracker sleep;
	StatTracker excercise;
	StatTracker diet;
	StatTracker water;
	GeneralStats allStats;
	HealthBot bill;


	@FXML
	private void initialize() {
		allStats = new GeneralStats();

		weight = new StatTracker(weightChart, homeWeight, weightText, goalWeight, "weight");
		bmi = new StatTracker(bMIChart, homeBMI, homeBMI, goalBMI, "BMI");
		sleep = new StatTracker(sleepChart, homeSleep, sleepText, goalSleep, "sleep");
		excercise = new StatTracker(excerciseChart, homeExcercise, excerciseText, goalExcercise, "excercise");
		diet = new StatTracker(dietChart, homeDiet, dietText, goalDiet, "diet");
		water = new StatTracker(waterChart, homeWater, waterText, goalWater, "water");

		dayNum.setText("Day: " + allStats.getDay());
		bill = new HealthBot(allStats);
		allStats.addStat(weight);
		allStats.addStat(bmi);
		allStats.addStat(sleep);
		allStats.addStat(excercise);
		allStats.addStat(diet);
		allStats.addStat(water);

	}

	private void moveText(StatTracker stat) {
		if (checkIn(stat.getTabField().getText())) {
			stat.getMainField().setText(stat.getName() + ": " + stat.getTabField().getText());
			stat.setAmount(stat.getTabField().getText());
			promptText(stat.getName(), stat.getTabField());
		}
	}
	@FXML
	public void nextDay() {
		if (bmi.getAmount() > 0) {
			allStats.nextDay();
			dayNum.setText("Day: " + allStats.getDay());
			botText.setText(bill.getGenericAdvice());
		}
	}
	@FXML
	public void getAdvice() {
		botText.setText(bill.getAdvice());
	}
	@FXML
	public void setWeight() {
		moveText(weight);
		setBMI();
	}
	@FXML
	private void setBMI() {
		if (weight.getAmount() > 0 && allStats.getHeight() > 0) {
			double temp = (weight.getAmount() * 703 / Math.pow(allStats.getHeight(), 2));
			bmi.getMainField().setText(bmi.getName() + ": " + temp);
			bmi.setAmount(temp);
		}
	}
	@FXML
	public void setSleep() {
		moveText(sleep);
	}
	@FXML
	public void setExcercise() {
		moveText(excercise);
	}
	@FXML
	public void setDiet() {
		moveText(diet);
	}
	@FXML
	public void setWater() {
		moveText(water);
	}

	private void promptText(String text, TextField box) {
		String temp = box.getText();
		if (checkIn(temp)) {
			box.setText("");
			box.setPromptText(text + ": " + temp);
		}
	}
	@FXML
	public void setgWeight() {
		promptText("Weight", goalWeight);
	}
	@FXML
	public void setgBMI() {
		promptText("BMI", goalBMI);
	}
	@FXML
	public void setgSleep() {
		promptText("Sleep", goalSleep);
	}
	@FXML
	public void setgExcercise() {
		promptText("Excercise", goalExcercise);
	}
	@FXML
	public void setgDiet() {
		promptText("Diet", goalDiet);
	}
	@FXML
	public void setgWater() {
		promptText("Water", goalWater);
	}
	@FXML
	public void setHeight() {
		if (checkIn(heightBox.getText())) {
			allStats.setHeight(Double.parseDouble(heightBox.getText()));
			setBMI();
			promptText("Height", heightBox);
		}
	}
	private boolean checkIn(String input) {
		boolean temp = false;
		if (Double.parseDouble(input) >= 0) {
			temp = true;
		}
		return temp;
	}

}