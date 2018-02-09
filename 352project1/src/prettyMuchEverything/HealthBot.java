package prettyMuchEverything;

import java.util.ArrayList;

public class HealthBot {
	ArrayList<String> generic;
	GeneralStats allStats;

	public HealthBot(GeneralStats stats) {
		allStats = stats;
		generic = new ArrayList();

		generic.add("Avoid sugar calories."); //health advice from https://www.healthline.com/nutrition/27-health-and-nutrition-tips#section8
		generic.add("Eat nuts. Their good for you.");
		generic.add("Avoid processed/junk food.");
		generic.add("Don't be afraid to drink coffee.");
		generic.add("Eat fatty fish.");
		generic.add("Make sure you get enough sleep.");
		generic.add("Take care of your gut health with probiotic and fiber.");
		generic.add("Drink plenty of water.");
		generic.add("Don't overcook or burn your meat.");
		generic.add("Avoid bright lights before going to sleep.");
		generic.add("Take vitamin D3 if you don't get enough sunlight.");
		generic.add("Eat fruits and vegetables.");
		generic.add("Make sure to eat enough protein.");
		generic.add("Do some cardio, or walk more.");
		generic.add("Don't smoke, and drink in moderation.");
		generic.add("Use extra virgin olive oil.");
		generic.add("Use plenty of herbs and spices.");
		generic.add("Take care of your relationships.");
		generic.add("Make sure you track your food intake.");
		generic.add("Eggs are a healthy part of a balanced diet.");
		generic.add("You can click on me to get different health tips.");

	}

	public String getGenericAdvice() {
		return generic.get((int)Math.floor(Math.random() * generic.size())) + "  Information taken from www.healthline.com/nutrition/27-health-and-nutrition-tips#section8";
	}

	public String getAdvice() {
		String advice;
		StatTracker stat = allStats.getStats().get(((int)Math.floor(allStats.getStats().size() * Math.random())));
		if (stat.getAmount() < 0) {
			advice = "Don't forget to fill in todays info for " + stat.getName();
		} else if (stat.getName().equals("sleep")) {
			advice = getSleepAdvice(stat);
		} else if (stat.getName().equals("weight")) {
			advice = getWeightAdvice(stat);
		} else if (stat.getName().equals("BMI")) {
			advice = getBMIAdvice(stat);
		} else if (stat.getName().equals("excercise")) {
			advice = getExcerciseAdvice(stat);
		} else if (stat.getName().equals("diet")) {
			advice = getDietAdvice(stat);
		} else if (stat.getName().equals("water")) {
			advice = "Almost no one agrees on how much water you should drink, except that you're probably not drinking enough.";
		} else {
			advice = getGenericAdvice();
		}
		return advice;
	}

	public String getSleepAdvice(StatTracker stat) {
		if (stat.getAmount() < 6) {
			return "You seem to not be getting enough sleep.";
		} else if (stat.getAmount() > 10) {
			return "You seem to be sleeping a lot.";
		} else {
			return "Eight hours of sleep is considered to be about the ideal amount.";
		}
	}

	public String getWeightAdvice(StatTracker stat) {
		return "Different body types and muscle mass have different healthy weights. Make sure you talk to your doctor about what's healthy for you.";
	}

	public String getBMIAdvice(StatTracker stat) {
		if (stat.getAmount() > 39) {
			return "According to your BMI you are classified as being Extremely Obese.";
		} else if (stat.getAmount() > 29) {
			return "According to your BMI you are Obese.";
		} else if (stat.getAmount() > 24) {
			return "You might be overweight.";
		} else if (stat.getAmount() > 18) {
			return "You have a healthy BMI.";
		} else {
			return "You appear to be underweight.";
		}
	}

	public String getExcerciseAdvice(StatTracker stat) {
		if (stat.getAmount() < 500) {
			return "Try getting out, or being more active.";
		} else {
			return "Good job being active! Try seeing if you can do a bit more.";
		}
	}

	public String getDietAdvice(StatTracker stat) {
		if (stat.getAmount() < 1000) {
			return "You might not be eating enough.";
		} else {
			return "Don't believe every fad diet. Ask your doctor about what could be helpful or harmful.";
		}
	}
}
