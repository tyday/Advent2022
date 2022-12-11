package net.tylerday.AdventofCode.day06;

import java.util.*;

public class Day06 {

//    List<String> testData = new ArrayList<>(List.of(
//            "mjqjpqmgbljsphdztnvjfqwrcgsmlb",
//            "nppdvjthqldpwncqszvftbrmjlhg",
//            "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg",
//            "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"
//    ));

//    String testData1 = "mjqjpqmgbljsphdztnvjfqwrcgsmlb";
//    String testData2 = "nppdvjthqldpwncqszvftbrmjlhg";
//    String testData3 = "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg";
//    String testData4 = "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw";


    public static void main(String[] args) {
//        String testData = "mjqjpqmgbljsphdztnvjfqwrcgsmlb";

//        System.out.println(testData.substring(0,4));

        System.out.println(partOne(LocalData.inputData, 4));
        System.out.println(partOne(LocalData.inputData, 14));
    }

    public static int partOne(String testData, int position) {

        ArrayDeque<Character> chars = new ArrayDeque<>();
        for (int i = 0; i < position; i++) {
            chars.add(testData.charAt(i));
        }

        for (int i = position; i < testData.length(); i++){
            Set<Character> test = new HashSet<>(chars.stream().toList());
            if(test.size() == position){
                System.out.println(chars);
                return i;
            }
            chars.poll();
            chars.add(testData.charAt(i));
        }

        return 0;
    }


}


class LocalData{
    static String inputData = "hqhnqhqshhslswsffchfcfbblvlblqlggfwwqfwwqdddbbbhzhjjrqjqbjqjwqjwqwhwrrmcrrjqjjlllcvcrrnpptzpzmmswmmzrzjrrfcrfccpbpzzvrrdndllttwftwwgzzwhwggdvdnnlrnncscbcfcctchcdchdccztzgzjjtdtcdtcchrrgpgzgsgpsggvtvppdccfhcfclfcfdfnddlbbptbtdbtdtjdjgdjjzljlssgbgcgqcqzccfnftfjjsgstggsngsscvssjzjnjtntvnvssrqqhtqtvqtvvjbvvbnvvqvmvrmmdsdvdwwnbnvbnvvcgvcczcfzftfsfrfsfttldtdrrgrgmgbbdvvbqbhqbqlqsqbsbpbgbvgbgwwrswrwrwttvnnzdnzzwggrmrfmmvllzwlwzzlvlbvllgsllpnlnvncvcvqqrwwcmcczhchzczbccdwcwvwzwwvddlwlhljlqjqnncntnctczzmwmlmccpggljlssqswsmmpvmvwvrrcpcrprmprrtdrtdrrsjsmshmmdpdlppbnbvvmmflmmjvjhvhjvjsjbjwjvvblvbvlbbllwlslvljvlvdvdgvgcchnhpnhnvhhtfhhvssczztlzzgvvqqghqgqssdscsnsrsmrmmwgwmgmlmdmggbgzbgzgdzdzccghgfgddtntftddpdrdrmrjmmmzttqmttnwngggtgtqtqnqhnqqpnnntrntrnnshhjtjzzfqqblqqlblslflmlttcwtwzzrlrnrcrrrgtrrftfhthzhggwggvgvvfvddcnddfjddzqzrrvtrvrfrrgpgrgngsgddlmddzgzppdzzjzhjhjhqqbpbvvlrvrsvrvnrrsgsttndnbngnppmlppvgvfggvcvrvnnsnfnnfqfwwppnddrrfqqgbqqfmmlnlnngwgcgjgnjgjsgjgqjjnccdttpqttswwcgcmgmccrppmqmbbfwwvdwdfwfjwfjjblldsdrdvvgcvcwwllfpllcslsvssnvsnvvhnvnvwwcgwccslsbbnlbnbrrrtprptpdpdvdttgsgwswppcdchhqbqcbqbzbgbbstshthsttqgtqtpqqzhhwhghwwmbbdlbbtlltsllbvbnvvmqvqtvqvttlwtltmmrttwgtwwfdddwcchtchhbthbbclczzqbzzpvvwzwswggjddntnrnnwmnnbdbmbccqgqvvsnvvqbvbzvvzmvzzrfrlfrfhhdvddnmnnmhmqhhrhlrldljlbljjgqqvdvhhgmgvgddmmznndmmhssznsswvwdvdzdhhscssntnftfmmrggbmbmgmlltctbtbntnqqscqcscrcrhrlhhdchhzccvvbfvvpfffbwbsbjjmgmwgmgppjnpjphhlmhhpwwhwzhhhzbbzzcbchhpnnptpvphhsdsccffqbqllchlhlwlcljlppnccqsstzstswtwwljwjmmpttvqqspsjjclljqqlhqqtnnbrrsbrbjjllrmrjmjzmmclmclmmcvvbddhnnmhmbbwqqqhrqqtqmqbqdbdtdvvcscshccmffhqffdgdcgddljdjbdbjbdbrrtjjtnntpntpnpmnpmpgghffrnfrnnmdnmnhmmjcjffftrrttfwfvwvcwwrmwmpwmmnvntthmmgmbbcdclcppjhpjhjwwlppgsszqqwggmttfrfqflfsfmmmhchshmmjtjjgdjjnnsvsmsnwcgdfqljmnphlfdrhpggfqnhnszgpndhdqcgfhtdcgbsbtmhvnnrmqzqqcjdqndzbnrhwjvbvcldmnwltgpqbmstntnggtbqjzzqrfdsfttdfrcnsrpwrjrjqbgtjfmlwsrzdbdqvbtczgsjqhtgmctjfmdglfrsvqtgwpbqghzgzdfwzhbdhlmhdvhwjrdhhtjptvwpmjnmfcjdmdczmczvdqwvbgtvlwvwnvdlbqfshmlmvzzcmjbtpwpwgsqhfsgljzhbppcztfjdntzcvllqnzrqjwfjrlgvhmbpvbtqjrdzcsmcjzcdsmvcmhrbhgnscnfrfmscqsqpqplbrzhsrlsvvpmfdtdmtlrtvspmlljmfpshfmstjgnrrwmqlbnwbndcfdstrtqtnzpfqlcgrzmsnmhllljdgtmvftjttbwhqzcqwbwdbshgcqrptfjwbbfsjnvzztlbdchqrlbbrcnsswmhwphfwrbnvrncbrthprmltlwwlfpbqhdfqzwwcwjgqzdnvmhwpzpbtpwwvzcpfcsfqpwjljzzfwzmlfvhsccppzlzjlrvlpdtjpcptnvqjwtdbzrqwnfwmmjndflqqggczrfjlpdfjffctprnmhfdqvnzbfvhszzdmngnlmwzfdrbvlvjnmbllgrczssqcrhbmnpmqlrzgmqmhgsvcdlqnmlhlzvqzhnccbctslzlbcpdvqltqncpcrzwdchrqmwfwlcbcvfnnpjntfrznqdjsdtzqjjttddwvnfqmznhflblzvvtbwdzrrlqlmndzzzwnpbhhlvlbswfjtbnhlccscbnfgjtwbfdlwvzszwnwzhlbcdpvgqjcrpzsvvnfwqcqvrmhzhggvmzwggdpbfrdscjwhsdsbbjcnzldhzcvqtjrhsbfjlrlpvtcqhnnsvslfrdjvjhfhdcfzqchpvvhzbpqglqlrdttrdtndzhnzhtqndghtgmpsnhptprqzhbbdcrgmbvrvqmbptqgnmsccwmhrlpddvmhjntllwrzqwnsjchnblcgndjtmpswwgcstdftqcbhzgttrhnpvrhspjznhhvrlpdqbzzrvzjphcswhljdldvsrdhzltwgrcsvqwnhtqqjjrjgrplzmsnjhzrfbtqgdfgnbpvjrfzrrpdphgzrfbswdhzgbzswqtwwdtrvvswmjvwhqddfzjhgdqsfnwbmlcfwtmpldrdpwjwggbpmncvbghzjmpsqpvnmbhjfzzpsjdgmrtnndhzrphjzdbgrrnthtrfnspdngbdmwbnfjlsndqswfsvfqftqlgqjpfsfpmdbsjfrptvbpvflqgvlmmbchhghhrwmvdlrhlsdtvjjchwglcrwfsfnnbhjbtccbjsfwrbzrvgsbfnvzghhrqblqchjvdtrrbrwwwmfnczzmmrqdggsfrqbldbbfbbcthtsvpcnlbjjztwvhctbrjltqdwbzmrrfslbmjpnqwllbvjzgfsfqqtwbgwgclgdflshfhwggwdqlgbmdmdqglrtfwbddtsltmsvswhgjtqwtnrncpdzhnpfqcjnjzmtbjfzpjwgfbfggmsmfdhfbjctnhchpgfspthdbfpmvrmdbbspvwzqqwnmfwdnnblbcjszbccgflngnjjwsqshfbhjwgzrmvsgnrdbgwfhdvpmznpnvznfcqdclztcptjrrpbmpztwwbvlvtmngfhmfbfmrjbjzlrcvgllrlgthltstnwmffntqrwsrndlzqhztwpcwbdjjztgdzmgtthcvtvnjzzhvstfqhgddddgdsrbcqzqspjrncphhtbnslzphrtfqphffjrrlgwbrwqfzzqvzhnffcwvrncttgplshccglvchvlcbnlthhmzvcrfjvjqfsjjzzgqlpslfwngqnbgcwffpcqhlmlhvwssrpjbrcbftpzbbpptzrdqwpzpdjhtwbvwcqbfnwtflfgzgttglpcwdnzsmjffgfftdnpzlpszmzrrhvlzdfpgbzqlvvfslnndcmjvvpwzwcdzpcttfwbsdswmfqbbhbfbjvbvtspbbhmphzjsjcmmzpvvzhtvzlgwlqqvbnrgtszvghjfmchrwwhpmbsvfmgvqdtmvdtjppchbsgqrtgtnzczqmpgjdbmmflfpjbcdmhldwpgdtdvsbzhztjzfhcsbndfjntbldjnqwdffqspfnlplbtcdjtwdjhldtsdfrnmpfhzghnpcqlhhgblmqjvwhndqfbccvzzlbzbdprvcpwjjhrqnjptwssbjhgvpgtfzqwrzjvbdgwtnmptvdjrffcmbzmzcmrfbjv";
}
