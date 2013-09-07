package com.mobenga.task.data.formating;

import com.mobenga.task.data.LivescoreData;
import com.mobenga.task.data.Match;
import com.mobenga.task.data.util.BaseIterationCallback;
import com.mobenga.task.data.util.Util;

import java.util.*;

public class TopListFormatter implements LivescoreDataFormatter {

    private class TopListElement {
        private TopListElement(Character teamSymbol, Integer goalsTotal) {
            this.teamSymbol = teamSymbol;
            this.goalsTotal = goalsTotal;
        }

        private Character teamSymbol;
        private Integer goalsTotal;
    }

    @Override
    public String format(LivescoreData livescoreData) {
        List<TopListElement> topList = getSortedTopList(livescoreData);
        StringBuilder formattedData = new StringBuilder();
        for (TopListElement element : topList) {
            formattedData.append(element.teamSymbol);
            formattedData.append(" - ");
            formattedData.append(element.goalsTotal);
            formattedData.append(System.getProperty("line.separator"));
        }
        return formattedData.toString();
    }

    protected List<TopListElement> getSortedTopList(LivescoreData livescoreData) {
        Map<Character, Integer> notSortedTopList = getNotSortedTopList(livescoreData);
        List<TopListElement> topList = new ArrayList<TopListElement>(notSortedTopList.keySet().size());
        for (Map.Entry<Character, Integer> entry : notSortedTopList.entrySet()) {
            topList.add(new TopListElement(entry.getKey(), entry.getValue()));
        }
        Collections.sort(topList, new Comparator<TopListElement>() {
            @Override
            public int compare(TopListElement o1, TopListElement o2) {
                return o2.goalsTotal - o1.goalsTotal;
            }
        });
        return topList;
    }

    protected Map<Character, Integer> getNotSortedTopList(LivescoreData livescoreData) {
        final Map<Character, Integer> topList = new HashMap<Character, Integer>();
        Util.iterateLivescoreData(livescoreData, new BaseIterationCallback() {
            @Override
            public boolean eachMatch(Match match) {
                if (match.getScores() == null || match.getScores().size() <= 0) return true;
                char[] teamSymbols = {match.getTeam1().getName().charAt(0), match.getTeam2().getName().charAt(0)};
                int[] teamGoals = {match.getScores().get(0).getTeam1(), match.getScores().get(0).getTeam2()};
                for (int n = 0; n < 2; n++) {
                    if (teamGoals[n] <= 0) continue;
                    Integer currGoalValue = topList.get(teamSymbols[n]);
                    if (currGoalValue == null) {
                        currGoalValue = 0;
                    }
                    currGoalValue += teamGoals[n];
                    topList.put(teamSymbols[n], currGoalValue);
                }
                return true;
            }
        });
        return topList;
    }
}
