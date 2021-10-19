class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int len = 0;
        String M = lower(m);

        for (String musicinfo : musicinfos) {
            String[] info = musicinfo.split(",");
            String[] start = info[0].split(":");
            String[] end = info[1].split(":");
            String title = info[2];
            String song = lower(info[3]);
            int min = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]) - Integer.parseInt(start[0]) * 60
                    - Integer.parseInt(start[1]);

            String melody = "";
            if (song.length() >= min) {
                melody = song.substring(0, min);
            } else {
                for (int i = 0; i < min / song.length(); i++) {
                    melody = melody.concat(song);
                }
                melody = melody.concat(song.substring(0, min % song.length()));
            }

            if (melody.contains(M)) {
                if (min > len) {
                    len = min;
                    answer = title;
                }
            }
        }

        return answer;
    }

    private String lower(String m) {
        m = m.replaceAll("C#", "c");
        m = m.replaceAll("D#", "d");
        m = m.replaceAll("F#", "f");
        m = m.replaceAll("G#", "g");
        m = m.replaceAll("A#", "a");
        return m;
    }
}