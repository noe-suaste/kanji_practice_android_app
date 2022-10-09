package com.nstudio.kanjipractice;

import java.util.ArrayList;
import java.util.Arrays;

public class CtrlKanji {
    // N5 kanjis declaration

    private ArrayList<Kanji> kanjis_N5 = new ArrayList<Kanji>(Arrays.asList(
            new Kanji(1 ,"日","nichi, jitsu","ニチ, ジツ","hi, -bi, -ka","ひ, -び, -か","day, sun, Japan, counter for days", true),
            new Kanji(2 ,"一","ichi","イチ","hito(tsu)","ひと(つ)","one", true),
            new Kanji(3 ,"国","koku","コク","kuni","くに","country", true),
            new Kanji(4 ,"人","jin, nin","ジン、 ニン","hito","ひと","person", true),
            new Kanji(5 ,"年","nen","ネン","toshi","とし","year, counter for years", true),
            new Kanji(6 ,"大","dai, tai","ダイ、 タイ","oo(kii)","おお(きい)","large, big", true),
            new Kanji(7 ,"十","juu","ジュウ","tou, to","とお、 と","ten, 10", true),
            new Kanji(8 ,"二","ni, ji","ニ、 ジ","futa(tsu)","ふた(つ)","two, 2", false),
            new Kanji(9 ,"本","hon","ホン","moto","もと","book, present, true, counter for long cylindrical things", false),
            new Kanji(10 ,"中","chuu","チュウ","naka, uchi, ata(ru)","なか、 うち、 あた(る)","in, inside, middle, mean, center", false),
            new Kanji(11 ,"長","chou","チョウ","naga(i), osa","なが(い)、 おさ","long, leader, superior, senior", false),
            new Kanji(12 ,"出","shutsu, sui","シュツ、 スイ","de(ru), da(su), i(deru)","で(る)、 だ(す)、 い(でる)","exit, leave, go out", false),
            new Kanji(13 ,"三","san","サン","mi(tsu)","み(つ)","three, 3", false),
            new Kanji(14 ,"時","ji","ジ","toki, doki","とき、 -どき","time, hour", false),
            new Kanji(15 ,"行","kou, gyou, an","コウ、 ギョウ、 アン","i(ku), yu(ku), okona(u)","い(く)、 ゆ(く)、 おこな(う)","going, journey, carry out, line, row", false),
            new Kanji(16 ,"見","ken","ケン","mi(ru), mi(seru)","み(る)、 み(せる)","see, hopes, chances, idea, opinion, look at, visible", false),
            new Kanji(17 ,"月","getsu, gatsu","ゲツ、 ガツ","tsuki","つき","month, moon", false),
            new Kanji(18 ,"分","bun, fun, bu","ブン、 フン、 ブ","wa(keru)","わ(ける)","part, minute of time, understand", false),
            new Kanji(19 ,"後","go, kou","ゴ、 コウ","nochi, ushi(ro), ato","のち、 うし(ろ)、 あと","behind, back, later", false),
            new Kanji(20 ,"前","zen","ゼン","mae","まえ","in front, before", false),
            new Kanji(21 ,"生","sei, shou","セイ、 ショウ","i(kiru), u(mu), o(u), ha(eru), nama","い(きる)、 う(む)、 お(う)、 は(える)、 なま","life, genuine, birth", false),
            new Kanji(22 ,"五","go","ゴ","itsu(tsu)","いつ(つ)","five, 5", false),
            new Kanji(23 ,"間","kan, ken","カン、 ケン","aida, ma, ai","あいだ、 ま、 あい","interval, space", false),
            new Kanji(24 ,"上","jou, shou, shan","ジョウ、 ショウ、 シャン","ue, uwa, kami, a(geru), nobo(ru), tatematsu(ru)","うえ、 うわ-、 かみ、 あ(げる)、 のぼ(る)、 たてまつ(る)","above, up", false),
            new Kanji(25 ,"東","tou","トウ","higashi","ひがし","east", false),
            new Kanji(26 ,"四","shi","シ","yo(tsu), yon","よ(つ)、 よん","four, 4", false),
            new Kanji(27 ,"今","kon, kin","コン、 キン","ima","いま","now; the present", false),
            new Kanji(28 ,"金","kin, kon, gon","キン、 コン、 ゴン","kane, kana, gane","かね、 かな-、 -がね","gold", false),
            new Kanji(29 ,"九","kyuu, ku","キュウ、 ク","kokono(tsu)","ここの(つ)","nine, 9", false),
            new Kanji(30 ,"入","nyuu","ニュウ","i(ru), hai(ru)","い(る)、はい(る)","enter, insert", false),
            new Kanji(31 ,"学","gaku","ガク","mana(bu)","まな(ぶ)","study, learning, science", false),
            new Kanji(32 ,"高","kou","コウ","taka(i)","たか(い)","tall, high, expensive", false),
            new Kanji(33 ,"円","en","エン","maru(i)","まる(い)","circle, yen, round", false),
            new Kanji(34 ,"子","shi, su, tsu","シ、 ス、 ツ","ko, ne","こ、 ね","child", false),
            new Kanji(35 ,"外","gai, ge","ガイ、 ゲ","soto, hoka, hazu-, to-","そと、 ほか、 はず(す)、 と-","outside", false),
            new Kanji(36 ,"八","hachi","ハチ","ya(tsu), you","や(つ)、 よう","eight, 8", false),
            new Kanji(37 ,"六","roku","ロク","mu(tsu), mui","む(つ)、 むい","six, 6", false),
            new Kanji(38 ,"下","ka, ge","カ、 ゲ","shita, shimo, moto, sa(geru), kuda(ru), o(rosu)","した、 しも、 もと、 さ(げる)、 くだ(る)、 お(ろす)","below, down, descend, give, low, inferior", false),
            new Kanji(39 ,"来","rai, tai","ライ、 タイ","kuru, kitaru, ki, ko","く.る、 きた.る、 き、 こ","come, due, next, cause, become", false),
            new Kanji(40 ,"気","ki, ke","キ、 ケ","iki","いき","spirit, mind, air, atmosphere, mood", false),
            new Kanji(41 ,"小","shou","ショウ","chii(sai), ko-, o-, sa-","ちい(さい)、 こ-、 お-、 さ-","little, small", false),
            new Kanji(42 ,"七","shichi","シチ","nana(tsu), nano","なな(つ)、 なの","seven, 7", false),
            new Kanji(43 ,"山","san, sen","サン、 セン","yama","やま","mountain", false),
            new Kanji(44 ,"話","wa","ワ","hana(su), hanashi","はな(す)、 はなし","tale, talk", false),
            new Kanji(45 ,"女","jo","ジョ","onnna, me","おんな、 め","woman, female", false),
            new Kanji(46 ,"北","hoku","ホク","kita","きた","north", false),
            new Kanji(47 ,"午","go","ゴ","uma","うま","noon, sign of the horse", false),
            new Kanji(48 ,"百","hyaku, byaku","ヒャク、 ビャク","momo","もも","hundred", false),
            new Kanji(49 ,"書","sho","ショ","kaku","か(く)","write", false),
            new Kanji(50 ,"先","sen","セン","saki, ma(zu)","さき、 ま(ず)","before, ahead, previous, future, precedence", false),
            new Kanji(51 ,"名","mei, myou","メイ、 ミョウ","na","な","name, noted, distinguished, reputation", false),
            new Kanji(52 ,"川","sen","セン","kawa","かわ","river, stream", false),
            new Kanji(53 ,"千","sen","セン","chi","ち","thousand", false),
            new Kanji(54 ,"水","sui","スイ","mizu","みず","water", false),
            new Kanji(55 ,"半","han","ハン","naka(ba)","なか(ば)","half, middle, odd number, semi-", false),
            new Kanji(56 ,"男","dan, nan","ダン、 ナン","otoko, o","おとこ、 お","male, man", false),
            new Kanji(57 ,"西","sei, sai","セイ、 サイ","nishi","にし","west", false),
            new Kanji(58 ,"電","den","デン","","","electricity, electric powered", false),
            new Kanji(59 ,"校","kou","コウ","","","school, exam", false),
            new Kanji(60 ,"語","go","ゴ","kata(ru)","かた(る)","word, speech, language", false),
            new Kanji(61 ,"土","do, to","ド、 ト","tsuchi","つち","soil, earth, ground", false),
            new Kanji(62 ,"木","boku, moku","ボク、 モク","ki, ko","き、 こ-","tree, wood", false),
            new Kanji(63 ,"聞","bun, mon","ブン、 モン","ki(ku)","き(く)","to hear; to listen; to ask", false),
            new Kanji(64 ,"食","shoku, jiki","ショク、 ジキ","k(u), ta(beru), ha(mu)","く(う)、 た(べる)、 は(む)","eat, food", false),
            new Kanji(65 ,"車","sha","シャ","kuruma","くるま","car, wheel", false),
            new Kanji(66 ,"何","ka","カ","nani, nan","なに、 なん","what", false),
            new Kanji(67 ,"南","nan, na","ナン、 ナ","minami","みなみ","south", false),
            new Kanji(68 ,"万","man, ban","マン、 バン","","","ten thousand, 10,000", false),
            new Kanji(69 ,"毎","mai","マイ","goto(ni)","ごと(に)","every", false),
            new Kanji(70 ,"白","haku, byaku","ハク、 ビャク","shiro(i)","しろ(い)","white", false),
            new Kanji(71 ,"天","ten","テン","amatsu","あまつ","heavens, sky, imperial", false),
            new Kanji(72 ,"母","bo","ボ","haha, kaa","はは、 かあ","mother", false),
            new Kanji(73 ,"火","ka","カ","hi, bi, ho","ひ、 -び、 ほ-","fire", false),
            new Kanji(74 ,"右","u, yuu","ウ、 ユウ","migi","みぎ","right", false),
            new Kanji(75 ,"読","doku, toku, tou","ドク、 トク、 トウ","yo(mu)","よ(む)","to read", false),
            new Kanji(76 ,"友","yuu","ユウ","tomo","とも","friend", false),
            new Kanji(77 ,"左","sa, sha","サ、 シャ","hidari","ひだり","left", false),
            new Kanji(78 ,"休","kyuu","キュウ","yasu(mu)","やす(む)","rest, day off, retire, sleep", false),
            new Kanji(79 ,"父","fu","フ","chichi, tou","ちち、 とう","father", false),
            new Kanji(80 ,"雨","u","ウ","ame, ama","あめ、 あま","rain", false)
    ));

    public CtrlKanji(){}

    ArrayList<Kanji> getN5Kanjis(){
        return this.kanjis_N5;
    }

}
