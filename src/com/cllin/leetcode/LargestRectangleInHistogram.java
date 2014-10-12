package com.cllin.leetcode;

import java.util.Stack;

import com.cllin.main.LeetCodeExercise;

/*
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
 * find the area of largest rectangle in the histogram.
 * 
 * Source: http://oj.leetcode.com/problems/largest-rectangle-in-histogram/
 */

public class LargestRectangleInHistogram extends LeetCodeExercise {

    private int[][] testSuite = {
            {2, 1, 5, 6, 2, 3},
            {0, 0, 0, 0, 0, 0, 0, 0, 2147483647},
            {9046155,17522430,44186957,40374643,77652689,89027934,97586333,68834337,62979669,1783127,29339118,83907628,48067922,22843915,11027247,73603247,32376863,12448072,7086475,2369889,5064817,88893600,61558880,77108330,32113014,21324782,28294417,18403046,39022240,58687324,80978280,584748,76209754,25165237,40959391,6378795,66709524,38545724,75213133,29689193,92845203,4552251,13596821,40913125,27396166,24624068,67032725,12289382,89588493,74119200,14659271,94653310,15529152,28734503,24277993,47642166,50059286,52572410,18561565,89081526,11259734,99539845,42182626,39985840,24705083,83142017,46364635,43930959,74204093,74094120,73620152,67049296,31162724,87216973,7962422,58558890,64357394,27511499,23364624,53945887,1630699,38023896,1115549,69676203,66758399,25393542,17318370,16817685,30482304,88396287,58415564,94258390,87936132,598190,34244230,65157567,36256560,80608866,9088526,10460653,7219338,82708678,77509950,38382062,22442004,37988724,49457305,39315750,65500223,72821929,93261637,19647274,63362177,46893538,89323477,30120577,24803433,59158199,99454614,55285737,47554486,10386530,2060480,88006971,63501073,36304710,53164538,99757633,69429928,14769417,62734638,76649267,49994447,40244588,15031329,24952803,30749664,64488634,64268553,48766239,89826916,10046542,68413513,53189093,56940081,10253343,83309670,81743514,69411542,35280637,89545603,69482381,98183519,91606083,57489352,61684592,27910794,63170242,13958577,49857074,30456011,76693216,26506341,80450459,69454156,94054023,5403262,52720173,11059009,22188168,1486412,885925,32234710,22416278,54075019,89174791,32669621,89901041,23434657,54597515,77698030,65496613,24079896,75881550,57102696,34085600,90082494,37529842,97255843,4041072,87386917,27711854,33250640,66409610,60678665,2704796,60463633,18598280,7941321,24038995,40786448,9427734,24924920,73021158,31844012,31516291,14712302,17029985,21417333,38146959,71627500,99115363,56159924,48223749,27513265,13262621,82309349,17595760,50792463,32081544,74153184,90695732,12309751,7403824,57105343,72988416,62624972,70085328,91586696,70566294,94124323,32373144,32510380,71565596,57910655,16870744,3081887,72622957,33900729,24499220,63286268,5528229,76130936,19446193,6268330,56160553,85225166,88577680,73756313,36017629,20659224,425849,79229714,32968975,60346025,88851409,58473744,22970998,58936737,50060440,46053644,5577413,34949937,31080376,77143009,92860592,47951120,80224896,65483549,81851849,57240469,81286169,39896430,85887757,732362,46164761,42048310,38473880,87258793,68320976,74491510,7918017,68746825,6237576,93403345,29092851,95088985,51877089,4580201,6542074,54453881,3150197,12119487,89403818,34230573,89262496,82264410,34698045,22003745,264311,16549894,31760566,81550481,8962676,70164675,34799195,7643789,64729337,73273076,94902582,85566665,280938,2820600,6829843,59034866,48740297,88439046,54123851,617386,45535599,60665925,7587619,48685796,72785413,96991438,35432721,14564261,31772200,70130766,89084358,32036512,39197012,73361276,66103345,48159688,96042303,53418892,55803478,13287993,26691968,3222412,98854658,79489258,6043012,5684501,38524124,7299661,94123547,45164327,60433399,39659146,5830253,68021019,40861294,31132018,65012457,76294015,98212631,96784657,98941133,39813342,81337521,38138145,65690970,47440866,38814186,61733274,53376111,47134016,75021267,32584431,50356428,26392277,12073690,8915793,32076779,3114166,16215454,78716678,794846,76648854,70892177,6625099,44669873,64269823,90273469,62198682,93080191,41002452,11499691,92021324,80815794,92837213,82675822,46506765,92794431,21490008,60756391,46170542,68624024,88294010,78754974,18980452,14686287,43345016,80412597,99279418,98975534,96628052,77996097,99770380,73276906,1404626,58911831,70463131,65674449,49185300,32661813,58754640}, 
            {1, 1, 1, 1, 1, 1, 1, 1, 1},
            null
    };
    
    private int index;
    private int area;
    
    @Override
    public void initialize() {
        testSuite[4] = new int[8892];
        for (int i = 1; i <= 8892; i++) {
            testSuite[4][i - 1] = i;
        }
    }

    @Override
    public void run() {
        initialize();
        
        for (index = 0; index < testSuite.length; index++) {
            area = largestRectangleArea(testSuite[index]);
            test();
        }
    }

    /*
     * Say, H is in non-descending order with size n, 
     * the maximum rectangle area between n and i is H(i) * (n - i + 1) 
     * 
     * In this question, H is in random order, so we need to build a stack that is in non-descending order.
     * 
     * There are two things to do:
     *     1) Build/maintain non-descending stack, S
     *     2) Calculate maximum rectangle area, A
     * 
     * Iterate the array:
     *         If H(i) >= S.peek()    || S.isEmpty()        ------ Still non-descending
     *             S.push(i)                            ------ Build/maintain the stack
     *         Else
     *             Get last maximal, im, A = h * w
     *             h = H(im)
     *             w = i || i - S.peek() - 1            ------ Calculate maximum rectangle area, A
     *                                                 ------ Why i? i is the local n, the rectangle stops here
     * 
     * In case of there are pending maximum after iterating the array once,
     * update maximum area based on the remaining in the stack. 
     */
    private int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        
        int max = 0;
        int length = heights.length;
        Stack<Integer> maximals = new Stack<Integer>();
        
        int i = 0;
        while (i < length) {
            if (maximals.isEmpty() || heights[i] >= heights[maximals.peek()]) {
                maximals.push(i++);
            } else {
                if (maximals.isEmpty()) continue;
                
                int lastMaximal = maximals.pop();
                
                int height = heights[lastMaximal];
                int width = (maximals.isEmpty())? i : (i - maximals.peek() - 1);
                
                max = Math.max(max, height * width);
            }
        }
        
        while (!maximals.isEmpty()) {
            int lastMaximal = maximals.pop();
            
            int height = heights[lastMaximal];
            int width = (maximals.isEmpty())? i : (i - maximals.peek() - 1);
            max = Math.max(max, height * width);
        }
        
        return max;
    }
    
    @Override
    public boolean test() {
        System.out.print("The largest are from the histogram [ ");
        for (int h : testSuite[index]) System.out.printf("%d ", h);
        
        System.out.printf("] is %d%n", area);
        return true;
    }

}
