package hinzehaley.com.scooponsite.pojo;

/**
 * Created by haleyhinze on 5/18/17.
 * * Code generated on http://pojo.sodhanalibrary.com/
 */

public class Meta
{
    private String statusCode;

    private String error;

    private Pagination pagination;

    public String getStatusCode ()
    {
        return statusCode;
    }

    public void setStatusCode (String statusCode)
    {
        this.statusCode = statusCode;
    }

    public String getError ()
{
    return error;
}

    public void setError (String error)
    {
        this.error = error;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    @Override
    public String toString()
    {
        //return "ClassPojo [statusCode = "+statusCode+", error = "+error+", pagination = "+pagination+"]";
        return "";
    }
}