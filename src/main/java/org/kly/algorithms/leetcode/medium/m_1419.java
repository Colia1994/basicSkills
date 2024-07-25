package org.kly.algorithms.leetcode.medium;

public class m_1419 {

    public int minNumberOfFrogs(String croakOfFrogs) {
        int c = 0;
        int r = 0;
        int o = 0;
        int a = 0;
        int k = 0;
        int totalNum = 0;
        int freeNum = 0;
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            char l = croakOfFrogs.charAt(i);
            switch (l) {
                case 'c':
                    if (freeNum <= 0) {
                        totalNum++;
                        freeNum++;
                    }
                    freeNum--;
                    c++;
                    break;
                case 'r':
                    c--;
                    r++;
                    if (c < 0) {
                        return -1;
                    }
                    break;
                case 'o':
                    r--;
                    o++;
                    if (r < 0) {
                        return -1;
                    }
                    break;
                case 'a':
                    o--;
                    a++;
                    if (o < 0) {
                        return -1;
                    }
                    break;
                case 'k':
                    a--;
                    k++;
                    if (a < 0) {
                        return -1;
                    }
                    freeNum++;
                    break;

            }

        }
        if (c != 0 || r != 0 || o != 0 || a != 0) {
            return -1;
        }
        return totalNum;
    }

    public static void main(String[] args) {
        m_1419 m = new m_1419();
        System.out.println(m.minNumberOfFrogs("ccccccccccrrccccccrcccccccccccrcccccccccrcccccccccccrcccccrcccrrcccccccccccccrocrrcccccccccrccrocccccrccccrrcccccccrrrcrrcrccrcoccroccrccccccccorocrocccrrrrcrccrcrcrcrccrcro" +
                "ccccrccccroorcacrkcccrrroacccrrrraocccrrcrrccorooccrocacckcrcrrrrrrkrrccrcoacrcorcrooccacorcrccccoocroacroraoaarcoorrcrcccccocrrcoccarrorccccrcraoocrrrcoaoroccooccororrrccrcrocrrcorooocorarccoccocrrrocaccrooaaarrcr" +
                "arooaarrarrororrcrcckracaccorarorocacrrarorrraoacrcokcarcoccoorcrrkaocorcrcrcrooorrcrroorkkaaarkraroraraarooccrkcrcraocooaoocraoorrrccoaraocoorrcokrararrkaakaooroorcororcaorckrrooooakcarokokcoarcccroaakkrrororacrkraooacrkaraoacaraorrorrakaokrokraccaockrookrokoororoooorroaoaokccraoraraokakrookkroakkaookkooraaocakrkokoraoarrakakkakaroaaocakkarkoocokokkrcorkkoorrkraoorkokkarkakokkkracocoaaaaakaraaooraokarrakkorokkoakokakakkcracarcaoaaoaoorcaakkraooaoakkrrroaoaoaarkkarkarkrooaookkroaaarkooakarakkooaokkoorkroaaaokoarkorraoraorcokokaakkaakrkaaokaaaroarkokokkokkkoakaaookkcakkrakooaooroaaaaooaooorkakrkkakkkkaokkooaakorkaroaorkkokaakaaaaaocrrkakrooaaroroakrakrkrakaoaaakokkaaoakrkkoakocaookkakooorkakoaaaaakkokakkorakaaaaoaarkokorkakokakckckookkraooaakokrrakkrkookkaaoakaaaokkaokkaaoakarkakaakkakorkaakkakkkakaaoaakkkaoaokkkakkkoaroookakaokaakkkkkkakoaooakc" +
                "okkkrrokkkkaoakckakokkoaokaakakaaakakaakakkkkrakoaokkaakkkkkokkkkkkkkrkakkokkroaakkakaoakkoakkkkkkakakakkkaakkkkakkkk"));
    }
}
