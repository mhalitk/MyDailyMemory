package gyte.ooaad.application;

public class ConcreteDiary extends Diary{
	
	private Diary diary;
	private Text text;
	
	public ConcreteDiary()
	{
		super();
		this.diary = null;
		this.text = null;
	}
	
	public ConcreteDiary(Diary theDiary, Text theText)
	{
		this.diary = theDiary;
		this.text = theText;
	}
	
	public void setDiary(Diary theDiary)
	{
		this.diary = theDiary;
	}
	
	public void setText(Text theText)
	{
		this.text = theText;
	}
	
	public Text getText()
	{
		return this.text;
	}
	
	public Diary getDiary()
	{
		return this.diary;
	}
}
