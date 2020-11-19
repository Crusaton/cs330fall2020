#include "Polyhedron.h"
#include "Composite.h"
#include <iostream>

//------------------------------------------------------------------------------
Composite::Composite()
    :Polyhedron("Composite")
{
}

//------------------------------------------------------------------------------
/**
 * @todo write this function
 */
Composite::Composite(const Composite& src)
    :Polyhedron("Composite")
{

    int origPolyhedrasize = src.allPolyhedra.size();

    for(int i = 0; i < origPolyhedrasize; i++)
    {
        Polyhedron* new_polyhedron = src.allPolyhedra[i]->clone();
        this->allPolyhedra.push_back(new_polyhedron);    
    }
    // Perform a deep copy... maybe the _add_ method can help...
    this->boundingBox.merge(src.getBoundingBox());

}

//------------------------------------------------------------------------------
/**
 * @todo write this function
 */
Composite::~Composite()
{
    // Delete each component polyhedra
   for (auto p: allPolyhedra)
   {
    delete p;
   }
   allPolyhedra.clear();
}

//------------------------------------------------------------------------------
void Composite::read(std::istream& ins){
    int numPolyhedra;

    ins >> numPolyhedra;

    allPolyhedra.resize(numPolyhedra);

    for (int i = 0; i < numPolyhedra; i++) {
        ins >> allPolyhedra[i];

        boundingBox.merge(allPolyhedra[i]->getBoundingBox());
    }
}

//------------------------------------------------------------------------------
/**
 * @todo write this function
 */
void Composite::display(std::ostream& outs) const
{
    Polyhedron::display(outs);

    outs << allPolyhedra.size() << " polyhedra" << "\n";
        
        for(auto p: this->allPolyhedra)
        {
        outs << "  ";
        p->display(outs);
        outs << "\n";
        }
    // Loop through all component polyhedra and
    // print (display) them
}

//------------------------------------------------------------------------------
/**
 * @todo write this function
 */
void Composite::scale(double scalingFactor)
{
    // Loop through all polyhedra and scale them
        for(auto p: allPolyhedra)
        {
        p->scale(scalingFactor);
        }
    // Do not forget the bounding box... after the loop
    this->boundingBox.scale(scalingFactor);
}

//------------------------------------------------------------------------------
Composite& Composite::operator=(Composite rhs)
{
    swap(*this, rhs);
    return *this;
}

//------------------------------------------------------------------------------
Composite::iterator Composite::begin()
{
    return allPolyhedra.begin();
}

//------------------------------------------------------------------------------
Composite::iterator Composite::end()
{
    return allPolyhedra.end();
}

//------------------------------------------------------------------------------
Composite::const_iterator Composite::begin() const
{
    return allPolyhedra.begin();
}

//------------------------------------------------------------------------------
Composite::const_iterator Composite::end() const
{
    return allPolyhedra.end();
}

//------------------------------------------------------------------------------
/**
 * @todo write this function
 */
void Composite::add(const Polyhedron* toAdd)
{
    Polyhedron* new_polyhedron = toAdd->clone();
    allPolyhedra.push_back(new_polyhedron);
    // Add one new polyhedra and _merge_ its boundingBox with _this->boundingBox_
    this->boundingBox.merge(new_polyhedron->getBoundingBox());
}

//------------------------------------------------------------------------------
void swap(Composite& lhs, Composite& rhs)
{
    using std::swap;

    std::swap(lhs.allPolyhedra, rhs.allPolyhedra);

    swap(lhs.boundingBox, rhs.boundingBox);
}
