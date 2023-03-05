using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace csharp.repository
{
    public interface IRepository<T, Tid>
    {
        void Add(T item);
        void Delete(T item);
        void Update(T item, Tid id);
        T FindById(Tid id);
        IEnumerable<T> FindAll();
        IList<T> GetAll();
    }
}
