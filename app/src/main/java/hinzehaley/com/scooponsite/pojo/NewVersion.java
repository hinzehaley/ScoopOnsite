package hinzehaley.com.scooponsite.pojo;

/**
 * Created by haleyhinze on 5/18/17.
 * Code generated on http://pojo.sodhanalibrary.com/
 */

public class NewVersion
{
    private String message;

    private boolean forceUpdate;

    private boolean isAvailable;

    public String getMessage ()
    {
        return message;
    }

    public void setMessage (String message)
    {
        this.message = message;
    }

    public boolean isForceUpdate() {
        return forceUpdate;
    }

    public void setForceUpdate(boolean forceUpdate) {
        this.forceUpdate = forceUpdate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [message = "+message+", forceUpdate = "+forceUpdate+", isAvailable = "+isAvailable+"]";
    }
}