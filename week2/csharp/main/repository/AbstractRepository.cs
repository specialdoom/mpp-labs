using System.Collections.ObjectModel;
using csharp.model;

namespace csharp.repository
{
    public class AbstractRepository<T, String> : IRepository<T, String> where T : IIdentifiable<String> where String : notnull
    {
        protected Dictionary<String, T> elements = new();

        public void Add(T item)
        {
            if (elements.ContainsKey(item.getId()))
            {
                throw new Exception("Element already exists!");
            }

            elements[item.getId()] = item;
        }

        public void Delete(T item)
        {
            elements.Remove(item.getId());
        }

        public IEnumerable<T> FindAll()
        {
            return elements.Values.ToList();
        }

        public T FindById(String id)
        {
            if (!elements.ContainsKey(id))
            {
                throw new Exception("Element does not exist!");
            }

            return elements[id];
        }

        public void Update(T item, String id)
        {
            if (!elements.ContainsKey(id))
            {
                throw new Exception("Element does not exist!");
            }

            elements[id] = item;
        }

        public IList<T> GetAll()
        {
            return elements.Values.ToList();
        }
    }
}
