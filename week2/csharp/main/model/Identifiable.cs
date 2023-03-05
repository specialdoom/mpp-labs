namespace csharp.model
{
    public interface IIdentifiable<Tid>
    {
        Tid getId();

        void setId(Tid id);
    }
}