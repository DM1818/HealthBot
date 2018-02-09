package prettyMuchEverything;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.TextField;

// series
public class StatTracker {
	Series series;
	LineChart chart;
	TextField mainText;
	TextField tabText;
	TextField goalText;
	String name;
	double amount;

	public StatTracker(LineChart chart, TextField mainText, TextField tabText, TextField goalText, String name) {
		series  = new XYChart.Series<>();
		this.chart = chart;
		this.mainText = mainText;
		this.tabText = tabText;
		this.goalText = goalText;
		this.name = name;
		this.amount = -1;

		chart.getData().add(series); //https://www.youtube.com/watch?v=CMmeFZyWWSI
	}

	public Series getSeries() {
		return series;
	}

	public LineChart getChart() {
		return chart;
	}

	public TextField getMainField() {
		return mainText;
	}

	public TextField getTabField() {
		return tabText;
	}

	public TextField getGoalField() {
		return goalText;
	}

	public String getName() {
		return name;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double newAmount) {
		amount = newAmount;
	}

	public void setAmount(String newAmount) {
		amount = Double.parseDouble(newAmount);
	}
}
