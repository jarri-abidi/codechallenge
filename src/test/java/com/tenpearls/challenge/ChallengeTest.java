package com.tenpearls.challenge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.tenpearls.challenge.Challenge.sortOddBeforeEven;

public class ChallengeTest {

    private static class TestCase {
        String desc;
        Integer[] input;
        Integer[] expected;

        TestCase(String desc, Integer[] input, Integer[] output) {
            this.desc = desc;
            this.input = input;
            this.expected = output;
        }
    }

    @Test
    public void sortOddBeforeEvenTest() {
        TestCase[] testTable = new TestCase[]{
                new TestCase("Base case", new Integer[]{3, 4, 2, 1, 6, 7}, new Integer[]{3, 1, 7, 4, 2, 6}),
                new TestCase("Empty lists", new Integer[]{}, new Integer[]{}),
                new TestCase("Repeating numbers", new Integer[]{3, 4, 2, 2, 1, 6, 7, 7, 7}, new Integer[]{3, 1, 7, 7, 7, 4, 2, 2, 6}),
                new TestCase("Non-absolute numbers", new Integer[]{-3, 4, -2, -1, 6, 7}, new Integer[]{-3, -1, 7, 4, -2, 6}),
                new TestCase("Only odd numbers", new Integer[]{9, 13, 1, 7, 5, 11}, new Integer[]{9, 13, 1, 7, 5, 11}),
                new TestCase("Only even numbers", new Integer[]{2, 12, 10, 6, 4, 38}, new Integer[]{2, 12, 10, 6, 4, 38}),
                new TestCase("Random case", new Integer[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, new Integer[]{9, 7, 5, 3, 1, 10, 8, 6, 4, 2, 0}),
                new TestCase("1000 numbers", new Integer[]{3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36, 39, 42, 45, 48, 51, 54, 57, 60, 63, 66, 69, 72, 75, 78, 81, 84, 87, 90, 93, 96, 99, 102, 105, 108, 111, 114, 117, 120, 123, 126, 129, 132, 135, 138, 141, 144, 147, 150, 153, 156, 159, 162, 165, 168, 171, 174, 177, 180, 183, 186, 189, 192, 195, 198, 201, 204, 207, 210, 213, 216, 219, 222, 225, 228, 231, 234, 237, 240, 243, 246, 249, 252, 255, 258, 261, 264, 267, 270, 273, 276, 279, 282, 285, 288, 291, 294, 297, 300, 303, 306, 309, 312, 315, 318, 321, 324, 327, 330, 333, 336, 339, 342, 345, 348, 351, 354, 357, 360, 363, 366, 369, 372, 375, 378, 381, 384, 387, 390, 393, 396, 399, 402, 405, 408, 411, 414, 417, 420, 423, 426, 429, 432, 435, 438, 441, 444, 447, 450, 453, 456, 459, 462, 465, 468, 471, 474, 477, 480, 483, 486, 489, 492, 495, 498, 501, 504, 507, 510, 513, 516, 519, 522, 525, 528, 531, 534, 537, 540, 543, 546, 549, 552, 555, 558, 561, 564, 567, 570, 573, 576, 579, 582, 585, 588, 591, 594, 597, 600, 603, 606, 609, 612, 615, 618, 621, 624, 627, 630, 633, 636, 639, 642, 645, 648, 651, 654, 657, 660, 663, 666, 669, 672, 675, 678, 681, 684, 687, 690, 693, 696, 699, 702, 705, 708, 711, 714, 717, 720, 723, 726, 729, 732, 735, 738, 741, 744, 747, 750, 753, 756, 759, 762, 765, 768, 771, 774, 777, 780, 783, 786, 789, 792, 795, 798, 801, 804, 807, 810, 813, 816, 819, 822, 825, 828, 831, 834, 837, 840, 843, 846, 849, 852, 855, 858, 861, 864, 867, 870, 873, 876, 879, 882, 885, 888, 891, 894, 897, 900, 903, 906, 909, 912, 915, 918, 921, 924, 927, 930, 933, 936, 939, 942, 945, 948, 951, 954, 957, 960, 963, 966, 969, 972, 975, 978, 981, 984, 987, 990, 993, 996, 999},
                        new Integer[]{3, 9, 15, 21, 27, 33, 39, 45, 51, 57, 63, 69, 75, 81, 87, 93, 99, 105, 111, 117, 123, 129, 135, 141, 147, 153, 159, 165, 171, 177, 183, 189, 195, 201, 207, 213, 219, 225, 231, 237, 243, 249, 255, 261, 267, 273, 279, 285, 291, 297, 303, 309, 315, 321, 327, 333, 339, 345, 351, 357, 363, 369, 375, 381, 387, 393, 399, 405, 411, 417, 423, 429, 435, 441, 447, 453, 459, 465, 471, 477, 483, 489, 495, 501, 507, 513, 519, 525, 531, 537, 543, 549, 555, 561, 567, 573, 579, 585, 591, 597, 603, 609, 615, 621, 627, 633, 639, 645, 651, 657, 663, 669, 675, 681, 687, 693, 699, 705, 711, 717, 723, 729, 735, 741, 747, 753, 759, 765, 771, 777, 783, 789, 795, 801, 807, 813, 819, 825, 831, 837, 843, 849, 855, 861, 867, 873, 879, 885, 891, 897, 903, 909, 915, 921, 927, 933, 939, 945, 951, 957, 963, 969, 975, 981, 987, 993, 999, 6, 12, 18, 24, 30, 36, 42, 48, 54, 60, 66, 72, 78, 84, 90, 96, 102, 108, 114, 120, 126, 132, 138, 144, 150, 156, 162, 168, 174, 180, 186, 192, 198, 204, 210, 216, 222, 228, 234, 240, 246, 252, 258, 264, 270, 276, 282, 288, 294, 300, 306, 312, 318, 324, 330, 336, 342, 348, 354, 360, 366, 372, 378, 384, 390, 396, 402, 408, 414, 420, 426, 432, 438, 444, 450, 456, 462, 468, 474, 480, 486, 492, 498, 504, 510, 516, 522, 528, 534, 540, 546, 552, 558, 564, 570, 576, 582, 588, 594, 600, 606, 612, 618, 624, 630, 636, 642, 648, 654, 660, 666, 672, 678, 684, 690, 696, 702, 708, 714, 720, 726, 732, 738, 744, 750, 756, 762, 768, 774, 780, 786, 792, 798, 804, 810, 816, 822, 828, 834, 840, 846, 852, 858, 864, 870, 876, 882, 888, 894, 900, 906, 912, 918, 924, 930, 936, 942, 948, 954, 960, 966, 972, 978, 984, 990, 996}),
        };

        for (TestCase tc : testTable) {
            Assertions.assertArrayEquals(tc.expected, sortOddBeforeEven(tc.input), tc.desc);
            System.out.printf("%s works: ✔️\n", tc.desc);
        }
    }
}
