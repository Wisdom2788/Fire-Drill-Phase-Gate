import java.util.ArrayList;
import java.util.Scanner;
public class MBTITest{
	public static void main(String[] args){
	Scanner entries = new Scanner(System.in);
	System.out.println("MBTI Personality Test");
	ArrayList<Character> answer = new ArrayList<>();
	ArrayList<Integer> number = new ArrayList<>();
	char ans = 'q';
	char troversion = 'q';
	int introversion =0;
	int extroversion =0;
	char focus = 'q';
	int sensing = 0;
	int Intuition =0;
	char dMaking = 'q';
	int thinking = 0;
	int feeling =0;
	char lifestyle = 'q';
	int judging = 0;
	int perceiving = 0;
	String personality = "" ;
	String personalityType = "";
	System.out.println();
	System.out.println("What your name");
	String name = entries.nextLine();
	System.out.println();
	String[] question = {
"0.A: expend energy, enjoy groups  |B: conserve energy, enjoy one-on-one ",
"1.A: interpret literally |B: look for meaning and possibilities ",
"2.A: logical, thinking, questioning |B: empathetic, feeling, accommodating",
"3.A: organized, orderly |B: flexible, adaptable ",
"4.A: more outgoing, think out loud |B: more reserved, think to yourself ", 
"5.A: practical, realistic, experiential |B: imaginative, innovative, theoretical",
"6.A: candid, straight forward, frank |B: tactful, kind, encouraging",
"7.A: plan, schedule |B: unplanned, spontaneous",
"8.A: seek many tasks, public activities, interaction with others |B: seek private, solitary activities with quiet to  concentrate ",
"9.A: Standard, usual, conventional |B: different, novel, unique",
"10.A: firm, tend to criticize, hold the line |B: gentle, tend to appreciate, conciliate", 
"11.A: regulated, structured |B: easygoing, 'live' and 'let live'",
"12.A: external, communicative, express yourself |B: internal, reticent, keep to yourself",
"13.A: focus on here-and-now |B: look to the future, global perspective, 'big picture'",
"14.A: tough-minded, just |B: tender-hearted, merciful", 
"15.A: preparation, plan ahead |B: go with the flow, adapt as you go", 
"16.A: active, initiate |B: reflective, deliberate",
"17.A: facts, things, 'what is' |B: ideas, dreams, 'what could be,' philosophical",
"18.A: matter of fact, issue-oriented |B: sensitive, people-oriented, compassionate", 
"19.A: control, govern |B: latitude, freedom"};





for(int count=0; count <=19; count++ ){
System.out.println(question[count]);
	ans = entries.next().charAt(0);
	while(ans != 'A' && ans != 'B'){
	System.out.println("wrong letter: Enter either A or B ");
	ans = entries.next().charAt(0);
}
	number.add(count);
	answer.add(ans);

}
	System.out.println(number);
	System.out.println(answer);

for(int count=0; count <=19; count+=4){

if (answer.get(count) == 'A'){
extroversion++;
} else if (answer.get(count) == 'B'){
introversion++;
}
}
System.out.println("EX "+extroversion);
System.out.println("IN "+introversion);
if (extroversion > introversion){
troversion = 'E';
} else if (introversion > extroversion){
troversion = 'I';
}
System.out.println(troversion);


for(int count=1; count <=19; count+=4){

if (answer.get(count) == 'A'){
sensing++;
} else if (answer.get(count) == 'B'){
Intuition++;
}
}
System.out.println("SE "+sensing);
System.out.println("IN "+Intuition);
if (sensing > Intuition){
focus = 'S';
} else if (Intuition > sensing){
focus = 'N';
}
System.out.println(focus);


for(int count=2; count <=19; count+=4){

if (answer.get(count) == 'A'){
thinking++;
} else if (answer.get(count) == 'B'){
feeling++;
}
}
System.out.println("TH "+thinking);
System.out.println("FE "+feeling);
if (thinking > feeling){
dMaking = 'T';
} else if (feeling > thinking){
dMaking = 'F';
}
System.out.println(dMaking);


for(int count=3; count <=19; count+=4){
if (answer.get(count) == 'A'){
judging++;
} else if (answer.get(count) == 'B'){
perceiving++;
}
}
System.out.println("JU "+judging);
System.out.println("PE "+perceiving);
if (judging > perceiving){
lifestyle = 'J';
} else if (perceiving > judging){
lifestyle = 'P';
}
System.out.println(lifestyle);


personality ="" + troversion + focus + dMaking + lifestyle;

System.out.println("Dear " +name+" your personality type is: "+ personality);



if( personality.equals("ISFJ") ){
System.out.println("Quiet, friendly, responsible, and conscientious. Committed and steady in meeting their obligations. Thorough, painstaking, and accurate. Loyal, considerate, notice and remember specifics about people who are important to them, concerned with how others feel. Strive to create an orderly and harmonious environment at work and at home.");
} else if( personality.equals("ISTJ") ){
System.out.println("Quiet, serious, earn success by being thorough and dependable. Practical, matter-of-fact, realistic, and responsible. Decide logically what should be done and work toward it steadily, regardless of distractions. Take pleasure in making everything orderly and organized—their work, their home, their life. Value traditions and loyalty.");
} else if( personality.equals("INFJ") ){
System.out.println("Seek meaning and connection in ideas, relationships, and material possessions. Want to understand what motivates people and are insightful about others. Conscientious and committed to their firm values. Develop a clear vision about how best to serve the common good. Organized and decisive in implementing their vision.");
} else if( personality.equals("INTJ") ){
System.out.println("Have original minds and great drive for implementing their ideas and achieving their goals. Quickly see patterns in external events and develop long-range explanatory perspectives. When committed, organize a job and carry it through. Skeptical and independent, have high standards of competence and performance—for themselves and others.");
} else if( personality.equals("ISTP") ){
System.out.println("Tolerant and flexible, quiet observers until a problem appears, then act quickly to find workable solutions. Analyze what makes things work and readily get through large amounts of data to isolate the core of practical problems. Interested in cause and effect, organize facts using logical principles, value efficiency.");
} else if( personality.equals("ISFP") ){
System.out.println("Quiet, friendly, sensitive, and kind. Enjoy the present moment, what's going on around them. Like to have their own space and to work within their own time frame. Loyal and committed to their values and to people who are important to them. Dislike disagreements and conflicts; don't force their opinions or values on others.");
} else if( personality.equals("INFP") ){
System.out.println("Idealistic, loyal to their values and to people who are important to them. Want to live a life that is congruent with their values. Curious, quick to see possibilities, can be catalysts for implementing ideas. Seek to understand people and to help them fulfill their potential. Adaptable, flexible, and accepting unless a value is threatened.");
} else if( personality.equals("INTP") ){
System.out.println("Seek to develop logical explanations for everything that interests them. Theoretical and abstract, interested more in ideas than in social interaction. Quiet, contained, flexible, and adaptable. Have unusual ability to focus in depth to solve problems in their area of interest. Skeptical, sometimes critical, always analytical.");
} else if( personality.equals("ESTP") ){
System.out.println("Seek to develop logical explanations for everything that interests them. Theoretical and abstract, interested more in ideas than in social interaction. Quiet, contained, flexible, and adaptable. Have unusual ability to focus in depth to solve problems in their area of interest. Skeptical, sometimes critical, always analytical.");
} else if( personality.equals("ESFP") ){
System.out.println("Outgoing, friendly, and accepting. Exuberant lovers of life, people, and material comforts. Enjoy working with others to make things happen. Bring common sense and a realistic approach to their work and make work fun. Flexible and spontaneous, adapt readily to new people and environments. Learn best by trying a new skill with other people.");
} else if( personality.equals("ENTP") ){
System.out.println("Quick, ingenious, stimulating, alert, and outspoken. Resourceful in solving new and challenging problems. Adept at generating conceptual possibilities and then analyzing them strategically. Good at reading other people. Bored by routine, will seldom do the same thing the same way, apt to turn to one new interest after another.");
} else if( personality.equals("ESTJ") ){
System.out.println("Practical, realistic, matter-of-fact. Decisive, quickly move to implement decisions. Organize projects and people to get things done, focus on getting results in the most efficient way possible. Take care of routine details. Have a clear set of logical standards, systematically follow them and want others to also. Forceful in implementing their plans.");
} else if(personality.equals("ESFJ") ){
System.out.println("Warmhearted, conscientious, and cooperative. Want harmony in their environment, work with determination to establish it. Like to work with others to complete tasks accurately and on time. Loyal, follow through even in small matters. Notice what others need in their day-to-day lives and try to provide it. Want to be appreciated for who they are and for what they contribute.");
} else if( personality.equals("ENFJ") ){
System.out.println("Warm, empathetic, responsive, and responsible. Highly attuned to the emotions, needs, and motivations of others. Find potential in everyone, want to help others fulfill their potential. May act as catalysts for individual and group growth. Loyal, responsive to praise and criticism. Sociable, facilitate others in a group, and provide inspiring leadership.");
} else if( personality.equals("ENTJ") ){
System.out.println("Frank, decisive, assume leadership readily. Quickly see illogical and inefficient procedures and policies, develop and implement comprehensive systems to solve organizational problems. Enjoy long-term planning and goal setting. Usually well informed, well read, enjoy expanding their knowledge and passing it on to others. Forceful in presenting their ideas.");
}

}
}