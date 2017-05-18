package hinzehaley.com.scooponsite.pojo;

/**
 * Created by haleyhinze on 5/18/17.
 * * Code generated on http://pojo.sodhanalibrary.com/
 */

public class Data
{
    private ContactNumbers contactNumbers;

    private String[] invalidCompanyEmailDomains;

    private NewVersion newVersion;

    private BackgroundImages backgroundImages;

   public ContactNumbers getContactNumbers ()
    {
        return contactNumbers;
    }

    public void setContactNumbers (ContactNumbers contactNumbers)
    {
        this.contactNumbers = contactNumbers;
    }

    public String[] getInvalidCompanyEmailDomains ()
    {
        return invalidCompanyEmailDomains;
    }

    public void setInvalidCompanyEmailDomains (String[] invalidCompanyEmailDomains)
    {
        this.invalidCompanyEmailDomains = invalidCompanyEmailDomains;
    }

    public NewVersion getNewVersion ()
    {
        return newVersion;
    }

    public void setNewVersion (NewVersion newVersion)
    {
        this.newVersion = newVersion;
    }

    public BackgroundImages getBackgroundImages ()
    {
        return backgroundImages;
    }

    public void setBackgroundImages (BackgroundImages backgroundImages)
    {
        this.backgroundImages = backgroundImages;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [contactNumbers = "+contactNumbers+", invalidCompanyEmailDomains = "+invalidCompanyEmailDomains+", newVersion = "+newVersion+", backgroundImages = "+backgroundImages+"]";
    }
}