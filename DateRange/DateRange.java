package DateRange;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.NoSuchElementException;
public class DateRange implements Iterable<LocalDate>{
	public LocalDate begin,end; 
	public DateRange(LocalDate begin,LocalDate end) {
		this.begin = begin ;
		this.end = end ; 
	}
	public Iterator<LocalDate> iterator(){
		return new DateRangeIterator(this.begin,this.end);
	}
	public boolean overlap(DateRange date){
		if(date.begin.isAfter(begin) && date.begin.isBefore(end) )
			return true;
		else if (date.begin.equals(begin) || date.end.equals(begin))
			return true;
		else if (date.begin.equals(end) || date.end.equals(end))
			return true;
		else 
			return false;
	}
	public boolean contains(LocalDate date){
		if(date.isAfter(begin) && date.isBefore(end))
			return true;
		else if(date.equals(begin)|| date.equals(end))
			return true;
		else 
			return false;
	}
}

class DateRangeIterator implements Iterator<LocalDate> {
    LocalDate begin,now,end;
    public DateRangeIterator(LocalDate begin, LocalDate end){
        this.begin = begin;
        this.end = end;
        this.now = begin;
    }

    public boolean hasNext() {
    	return now.plusDays(1).isBefore(end);
    }

    public LocalDate next() {
        if (!hasNext()) throw new NoSuchElementException();
        LocalDate now = this.now;
        this.now = this.now.plusDays(1);
        return now;
    }
    
}