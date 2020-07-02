using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HW3
{
    public interface IQueueInterface<T>
    {
        /// <returns>
        /// the element that was enqueued
        /// </returns>
        T Push(T element);

        /// <exception cref="QueueUnderflowException">
        /// if the queue is empty
        /// </exception>
        T Pop();

        /// <exception cref="QueueUnderflowException">
        /// if the queue is empty
        /// </exception>
        T Peek();

        /// <returns>
        /// true if the queue is empty; otherwise false
        /// </returns>
        bool GetisNullOrEmpty { get; }
    }
}
